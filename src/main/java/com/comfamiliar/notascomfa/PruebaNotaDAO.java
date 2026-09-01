
package com.comfamiliar.notascomfa;

import com.comfamiliar.notascomfa.dao.NotaDAO;
import com.comfamiliar.notascomfa.modelo.Nota;

public class PruebaNotaDAO {

    public static void main(String[] args) {

        NotaDAO notaDAO = new NotaDAO();

        // ELIMINAR NOTA ID 7
        if (notaDAO.eliminar(7)) {
            System.out.println("Nota eliminada correctamente.");
        } else {
            System.out.println("No se pudo eliminar la nota.");
        }

        // CONSULTAR
        System.out.println("\n--- LISTADO DE NOTAS ---");

        for (Nota nota : notaDAO.listar()) {

            System.out.println(
                    "ID: " + nota.getIdNotas()
                    + " | Estudiante: " + nota.getIdEstudiante()
                    + " | Asignatura: " + nota.getIdAsignatura()
                    + " | Nota: " + nota.getNota()
                    + " | Periodo: " + nota.getPeriodo()
            );
        }
    }
}
