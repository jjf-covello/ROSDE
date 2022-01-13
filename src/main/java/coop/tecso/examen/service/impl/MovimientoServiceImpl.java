package coop.tecso.examen.service.impl;

import coop.tecso.examen.dto.movimientos.MovimientoDTO;
import coop.tecso.examen.model.cc.CuentaCorriente;
import coop.tecso.examen.model.movimiento.Movimiento;
import coop.tecso.examen.repository.CuentaCorrienteRepository;
import coop.tecso.examen.repository.MovimientoRepository;
import coop.tecso.examen.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Date;

import static coop.tecso.examen.utils.ReflectionUtils.getTipomovInstaceFromClassName;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    private MovimientoRepository repository;

    @Override
    public Movimiento createFromDTO(CuentaCorriente cc, MovimientoDTO dto) {
        try {
            return repository.save(new Movimiento(
                    cc,
                    Date.valueOf(dto.getFecha()),
                    dto.getDescripcion(),
                    getTipomovInstaceFromClassName(dto.getTipoMovimiento()),
                    new BigDecimal(dto.getImporte())
            ));
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
