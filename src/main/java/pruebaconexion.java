package com.comfamiliar.sistemanotas;

import com.comfamiliar.sistemanotas.conexion.ConexionBD;
import java.sql.Connection;

public class pruebaconexion {

    public static void main(String[] args) {

        try (Connection conexion = ConexionBD.obtenerConexion()) {

            System.out.println(
                    "CONEXION EXITOSA A LA BASE DE DATOS"
            );

        } catch (Exception e) {

            System.out.println(
                    "ERROR DE CONEXION: "
                    + e.getMessage()
            );
        }
    }
}
