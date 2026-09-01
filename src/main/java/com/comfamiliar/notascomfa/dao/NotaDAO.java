package com.comfamiliar.notascomfa.dao;

import com.comfamiliar.notascomfa.conexion.ConexionBD;
import com.comfamiliar.notascomfa.modelo.Nota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotaDAO {

    // INSERTAR
    public boolean insertar(Nota nota) {

        String sql = "INSERT INTO notas "
                + "(id_estudiante, id_asignatura, nota, periodo) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, nota.getIdEstudiante());
            sentencia.setInt(2, nota.getIdAsignatura());
            sentencia.setDouble(3, nota.getNota());
            sentencia.setString(4, nota.getPeriodo());

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar nota: "
                    + e.getMessage());
            return false;
        }
    }

    // CONSULTAR TODAS
    public List<Nota> listar() {

        List<Nota> notas = new ArrayList<>();

        String sql = "SELECT id_notas, id_estudiante, "
                + "id_asignatura, nota, periodo "
                + "FROM notas";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {

                Nota nota = new Nota();

                nota.setIdNotas(resultado.getInt("id_notas"));
                nota.setIdEstudiante(
                        resultado.getInt("id_estudiante"));
                nota.setIdAsignatura(
                        resultado.getInt("id_asignatura"));
                nota.setNota(resultado.getDouble("nota"));
                nota.setPeriodo(resultado.getString("periodo"));

                notas.add(nota);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar notas: "
                    + e.getMessage());
        }

        return notas;
    }

    // ACTUALIZAR
    public boolean actualizar(Nota nota) {

        String sql = "UPDATE notas SET "
                + "id_estudiante = ?, "
                + "id_asignatura = ?, "
                + "nota = ?, "
                + "periodo = ? "
                + "WHERE id_notas = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, nota.getIdEstudiante());
            sentencia.setInt(2, nota.getIdAsignatura());
            sentencia.setDouble(3, nota.getNota());
            sentencia.setString(4, nota.getPeriodo());
            sentencia.setInt(5, nota.getIdNotas());

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar nota: "
                    + e.getMessage());
            return false;
        }
    }

    // ELIMINAR
    public boolean eliminar(int idNotas) {

        String sql = "DELETE FROM notas WHERE id_notas = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idNotas);

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar nota: "
                    + e.getMessage());
            return false;
        }
    }
}