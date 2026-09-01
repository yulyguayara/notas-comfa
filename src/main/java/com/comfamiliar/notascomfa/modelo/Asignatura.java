package com.comfamiliar.notascomfa.modelo;

public class Asignatura {

    private int idAsignatura;
    private String nombreAsignatura;
    private String descripcionAsignatura;

    public Asignatura() {
    }

    public Asignatura(int idAsignatura, String nombreAsignatura,
            String descripcionAsignatura) {

        this.idAsignatura = idAsignatura;
        this.nombreAsignatura = nombreAsignatura;
        this.descripcionAsignatura = descripcionAsignatura;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public String getDescripcionAsignatura() {
        return descripcionAsignatura;
    }

    public void setDescripcionAsignatura(String descripcionAsignatura) {
        this.descripcionAsignatura = descripcionAsignatura;
    }
}
