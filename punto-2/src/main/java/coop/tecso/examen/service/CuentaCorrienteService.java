package coop.tecso.examen.service;

import coop.tecso.examen.dto.movimientos.CuentaCorrienteDTO;
import coop.tecso.examen.model.cc.CuentaCorriente;
import org.springframework.data.domain.Page;

public interface CuentaCorrienteService {
    Page<CuentaCorriente> getAllCuentas(Integer page, Integer pageSize);

    void deleteByNro(String nro);

    void create(CuentaCorrienteDTO cc);

    Integer contarMovimeintos(String nro);

    void editarCC(CuentaCorrienteDTO cc, String nro);

    void actualizarCC(String nro, CuentaCorrienteDTO cc);
}
