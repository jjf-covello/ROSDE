package coop.tecso.examen.model.titular;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "persona_juridica")
@DiscriminatorValue("JURIDICA")
public class PersonaJuridica extends Titular {

    @Column(name="razon_social", length = 200)
    private String razonSocial;

    @Column(name="anio_fundacion")
    private Date anioFundacion;

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Date getAnioFundacion() {
        return anioFundacion;
    }

    public void setAnioFundacion(Date anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

    public PersonaJuridica(String razonSocial, Date anioFundacion, String rut) {
        this.razonSocial = razonSocial;
        this.anioFundacion = anioFundacion;
        this.RUT = rut;
    }

    public PersonaJuridica() {
    }
}
