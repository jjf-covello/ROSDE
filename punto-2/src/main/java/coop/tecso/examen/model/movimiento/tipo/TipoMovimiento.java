package coop.tecso.examen.model.movimiento.tipo;

import coop.tecso.examen.model.cc.CuentaCorriente;
import coop.tecso.examen.model.exception.ExcepcionAplicativo;
import coop.tecso.examen.model.movimiento.Movimiento;

import java.math.BigDecimal;

public abstract class TipoMovimiento {
    protected void validarSaldoMovimiento(Movimiento mov){
        BigDecimal extraccion = mov.getImporte();
        if(extraccion.signum()<0){
            throw new ExcepcionAplicativo("El valor dle movimiento " +
                    mov.getDescripcion() + " es invalido-");
        }
    }
    public abstract void aplicarMovimiento(CuentaCorriente cc, Movimiento mov);
}
