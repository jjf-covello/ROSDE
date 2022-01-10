package coop.tecso.examen.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_persona",
        discriminatorType = DiscriminatorType.STRING)
public abstract class Titular extends AbstractPersistentObject {

    @Column(name = "RUT", length = 13, unique = true)
    protected String RUT;

    public String getRUT() {
        return RUT;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    public Titular() {
    }

    public Titular(String RUT) {
        this.RUT = RUT;
    }
}
