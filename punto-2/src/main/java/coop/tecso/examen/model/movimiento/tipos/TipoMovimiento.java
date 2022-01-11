package coop.tecso.examen.model.movimiento.tipos;

import coop.tecso.examen.model.cc.CuentaCorriente;
import coop.tecso.examen.model.movimiento.Movimiento;

public interface TipoMovimiento {
    void aplicarMovimiento(CuentaCorriente cc, Movimiento mov);
}
