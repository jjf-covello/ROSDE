package coop.tecso.examen.service;

import coop.tecso.examen.dto.movimientos.MovimientoDTO;
import coop.tecso.examen.model.cc.CuentaCorriente;
import coop.tecso.examen.model.movimiento.Movimiento;

public interface MovimientoService {
    Movimiento createFromDTO(CuentaCorriente cc, MovimientoDTO dto);
}
