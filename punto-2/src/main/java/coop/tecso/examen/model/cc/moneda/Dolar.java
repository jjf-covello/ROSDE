package coop.tecso.examen.model.cc.moneda;

import coop.tecso.examen.model.cc.CuentaCorriente;
import coop.tecso.examen.model.exception.ExcepcionAplicativo;
import coop.tecso.examen.model.movimiento.Movimiento;

import java.math.BigDecimal;

public class Dolar extends Moneda {
    @Override
    public void verificarGiro(CuentaCorriente cc, Movimiento mov) {
        if(superaTope(cc, mov)) {
            throw new ExcepcionAplicativo("Los fondos de la cuenta " + cc.getNro()
                    + " sobrepasaron el limite al descubierto para cuentas en dolares");
        }
    }
    public Dolar(){
        this.valorMaximoAlDescubierto =
                new BigDecimal(300).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
