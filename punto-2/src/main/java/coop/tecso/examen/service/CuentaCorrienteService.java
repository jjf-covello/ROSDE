package coop.tecso.examen.service;

import coop.tecso.examen.dto.movimientos.CuentaCorrienteDTO;
import coop.tecso.examen.dto.movimientos.MovimientoDTO;
import coop.tecso.examen.model.cc.CuentaCorriente;
import coop.tecso.examen.model.movimiento.Movimiento;
import org.springframework.data.domain.Page;

public interface CuentaCorrienteService {
    Page<CuentaCorriente> getAllCuentas(Integer page, Integer pageSize);

    void deleteByNro(String nro);

    void create(CuentaCorrienteDTO cc);

    Integer contarMovimeintos(String nro);

    void editarCC(CuentaCorrienteDTO cc, String nro);

    void actualizarCC(String nro, CuentaCorrienteDTO cc);

    Page<Movimiento> getMovsPorCuenta(String nro, Integer page, Integer pageSize);

    CuentaCorriente getCuenta(String nro);

    void crearYAgregarMovimiento(String nro, MovimientoDTO dto);
}
