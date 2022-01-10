package coop.tecso.examen.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "persona_fisica")
@DiscriminatorValue("FISICA")
public class PersonaFisica extends Titular {

    @Column(name = "nombre", length = 80)
    private String nombre;

    @Column(name = "apellido", length = 250)
    private String apellido;

    @Column(name = "CC", length=30)
    private String CC;

    public PersonaFisica(String rut, String apellido, String nombre, String cc) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.CC = cc;
        this.RUT = rut;
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

    public String getCC() {
        return CC;
    }

    public void setCC(String CC) {
        this.CC = CC;
    }
}
