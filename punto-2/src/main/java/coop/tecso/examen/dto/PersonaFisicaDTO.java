package coop.tecso.examen.dto;

import coop.tecso.examen.model.PersonaFisica;

public class PersonaFisicaDTO {

    private String RUT;
    private String nombre;
    private String apellido;
    private String cc;

    public PersonaFisicaDTO(String rut, String nombre, String apellido, String cc) {
        this.RUT = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cc = cc;
    }

    public PersonaFisicaDTO() {
    }

    public static PersonaFisicaDTO GenerateFrom(PersonaFisica persona) {
        return new PersonaFisicaDTO(persona.getRUT(), persona.getNombre(), persona.getApellido(), persona.getCC());
    }

    public String getRUT() {
        return RUT;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }
}
