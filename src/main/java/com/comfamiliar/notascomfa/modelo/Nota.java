package com.comfamiliar.notascomfa.modelo;

public class Nota {

    private int idNotas;
    private int idEstudiante;
    private int idAsignatura;
    private double nota;
    private String periodo;

    public Nota() {
    }

    public Nota(int idNotas, int idEstudiante, int idAsignatura,
            double nota, String periodo) {

        this.idNotas = idNotas;
        this.idEstudiante = idEstudiante;
        this.idAsignatura = idAsignatura;
        this.nota = nota;
        this.periodo = periodo;
    }

    public int getIdNotas() {
        return idNotas;
    }

    public void setIdNotas(int idNotas) {
        this.idNotas = idNotas;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
