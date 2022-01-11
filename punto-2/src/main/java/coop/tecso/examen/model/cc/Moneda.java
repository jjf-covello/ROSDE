package coop.tecso.examen.model.cc;

import coop.tecso.examen.model.AbstractPersistentObject;
import coop.tecso.examen.model.movimiento.Movimiento;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Entity
@Embeddable
public abstract class Moneda extends AbstractPersistentObject {
    protected String moneda;

    public abstract void verificarGiro(CuentaCorriente cc, Movimiento mov);
}
