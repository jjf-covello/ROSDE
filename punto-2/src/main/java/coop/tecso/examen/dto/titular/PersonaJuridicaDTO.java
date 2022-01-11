package coop.tecso.examen.dto.titular;

import coop.tecso.examen.model.titular.PersonaJuridica;

public class PersonaJuridicaDTO {


    private String razonSocial;

    private String anioFundacion;

    private String RUT;

    public PersonaJuridicaDTO() {
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getAnioFundacion() {
        return anioFundacion;
    }

    public void setAnioFundacion(String anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

    public String getRUT() {
        return RUT;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    public PersonaJuridicaDTO(String razonSocial, String anioFundacion, String RUT) {
        this.razonSocial = razonSocial;
        this.anioFundacion = anioFundacion;
        this.RUT = RUT;
    }

    public static PersonaJuridicaDTO GenerateFrom(PersonaJuridica persona) {
        return new PersonaJuridicaDTO(persona.getRazonSocial(), persona.getAnioFundacion().toString(), persona.getRUT());
    }
}
