package coop.tecso.examen.model.cc.moneda;

import coop.tecso.examen.model.cc.CuentaCorriente;
import coop.tecso.examen.model.movimiento.Movimiento;

import java.math.BigDecimal;


public abstract class Moneda {
    protected BigDecimal valorMaximoAlDescubierto;

    public abstract void verificarGiro(CuentaCorriente cc, Movimiento mov);

    protected Boolean superaTope(CuentaCorriente cc, Movimiento mov){
        BigDecimal aux = cc.getSaldo().subtract(mov.getImporte());
        return aux.compareTo(valorMaximoAlDescubierto)<0;
    }
}
