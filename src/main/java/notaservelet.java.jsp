package com.comfamiliar.notascomfa.web;

import com.comfamiliar.notascomfa.dao.NotaDAO;
import com.comfamiliar.notascomfa.modelo.Nota;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Atiende las operaciones web de consulta y registro de notas.
 */
@WebServlet("/api/notas")
public class NotaServlet extends HttpServlet {

    private final NotaDAO notaDAO = new NotaDAO();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        List<Nota> notas = notaDAO.listar();
        response.getWriter().write(gson.toJson(notas));
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            int idEstudiante = Integer.parseInt(
                    request.getParameter("idEstudiante"));
            int idAsignatura = Integer.parseInt(
                    request.getParameter("idAsignatura"));
            double calificacion = Double.parseDouble(
                    request.getParameter("nota"));
            String periodo = request.getParameter("periodo");

            // Validar los datos antes de guardarlos.
            if (idEstudiante <= 0 || idAsignatura <= 0
                    || calificacion < 0 || calificacion > 5
                    || periodo == null || periodo.trim().isEmpty()) {

                response.setStatus(
                        HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write(
                        "{\"error\":\"Datos inválidos. Verifique la nota y los campos.\"}");
                return;
            }

            Nota nota = new Nota();
            nota.setIdEstudiante(idEstudiante);
            nota.setIdAsignatura(idAsignatura);
            nota.setNota(calificacion);
            nota.setPeriodo(periodo.trim());

            if (notaDAO.insertar(nota)) {
                response.setStatus(
                        HttpServletResponse.SC_CREATED);
                response.getWriter().write(
                        "{\"mensaje\":\"Nota registrada correctamente.\"}");
            } else {
                response.setStatus(
                        HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write(
                        "{\"error\":\"No fue posible registrar la nota.\"}");
            }

        } catch (NumberFormatException e) {
            response.setStatus(
                    HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write(
                    "{\"error\":\"Los identificadores y la nota deben ser numéricos.\"}");
        }
    }
}
