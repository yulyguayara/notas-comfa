package com.comfamiliar.notascomfa.modelo;

public class Estudiantes{

    private int idEstudiante;
    private String nombresEstudiantes;
    private String apellidosEstudiantes;
    private String correoEstudiante;
    private String telefonoEstudiante;

    public Estudiantes() {
    }

    public Estudiantes(int idEstudiante, String nombresEstudiantes,
            String apellidosEstudiantes, String correoEstudiante,
            String telefonoEstudiante) {

        this.idEstudiante = idEstudiante;
        this.nombresEstudiantes = nombresEstudiantes;
        this.apellidosEstudiantes = apellidosEstudiantes;
        this.correoEstudiante = correoEstudiante;
        this.telefonoEstudiante = telefonoEstudiante;
    }

    public int getIdEstudiantes() {
        return idEstudiante;
    }

    public void setIdEstudiantes(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombresEstudiantes() {
        return nombresEstudiantes;
    }

    public void setNombresEstudiantes(String nombresEstudiantes) {
        this.nombresEstudiantes = nombresEstudiantes;
    }

    public String getApellidosEstudiantes() {
        return apellidosEstudiantes;
    }

    public void setApellidosEstudiantes(String apellidosEstudiantes) {
        this.apellidosEstudiantes = apellidosEstudiantes;
    }

    public String getCorreoEstudiantes() {
        return correoEstudiante;
    }

    public void setCorreoEstudiantes(String correoEstudiante) {
        this.correoEstudiante = correoEstudiante;
    }

    public String getTelefonoEstudiantes() {
        return telefonoEstudiante;
    }

    public void setTelefonoEstudiantes(String telefonoEstudiante) {
        this.telefonoEstudiante = telefonoEstudiante;
    }
}
