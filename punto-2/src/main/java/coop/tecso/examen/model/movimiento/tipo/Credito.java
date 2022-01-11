package coop.tecso.examen.model.movimiento.tipo;

import coop.tecso.examen.model.cc.CuentaCorriente;
import coop.tecso.examen.model.movimiento.Movimiento;

import java.math.BigDecimal;

public class Credito extends TipoMovimiento {

    @Override
    public void aplicarMovimiento(CuentaCorriente cc, Movimiento mov) {
        cc.setSaldo(cc.getSaldo().setScale(2, BigDecimal.ROUND_HALF_UP)
                .add(mov.getImporte().setScale(2, BigDecimal.ROUND_HALF_UP))
        );
    }
}
