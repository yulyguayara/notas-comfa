package com.comfamiliar.notascomfa;

import com.comfamiliar.notascomfa.conexion.ConexionBD;
import java.sql.Connection;
import java.sql.SQLException;

public class PruebaConexion {

    public static void main(String[] args) {

        try (Connection conexion = ConexionBD.obtenerConexion()) {

            System.out.println(
                    "CONEXION EXITOSA A LA BASE DE DATOS"
            );

        } catch (SQLException e) {

            System.out.println(
                    "ERROR DE CONEXION: "
                    + e.getMessage()
            );
        }
    }
}
