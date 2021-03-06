package coop.tecso.examen.model.movimiento.tipo;

import coop.tecso.examen.model.cc.CuentaCorriente;
import coop.tecso.examen.model.movimiento.Movimiento;

import java.math.BigDecimal;

public class Debito extends TipoMovimiento {

    @Override
    public void aplicarMovimiento(CuentaCorriente cc, Movimiento mov) {
        cc.getMoneda().verificarGiro(cc,mov);
        validarSaldoMovimiento(mov);
        cc.setSaldo(cc.getSaldo().setScale(2, BigDecimal.ROUND_HALF_UP)
                .subtract(mov.getImporte().setScale(2, BigDecimal.ROUND_HALF_UP))
        );
    }

}
