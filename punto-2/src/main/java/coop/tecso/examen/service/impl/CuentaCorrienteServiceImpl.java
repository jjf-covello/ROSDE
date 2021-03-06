package coop.tecso.examen.service.impl;

import coop.tecso.examen.dto.movimientos.CuentaCorrienteDTO;
import coop.tecso.examen.dto.movimientos.MovimientoDTO;
import coop.tecso.examen.model.cc.CuentaCorriente;
import coop.tecso.examen.model.exception.ExcepcionAplicativo;
import coop.tecso.examen.model.movimiento.Movimiento;
import coop.tecso.examen.repository.CuentaCorrienteRepository;
import coop.tecso.examen.service.CuentaCorrienteService;
import coop.tecso.examen.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import static coop.tecso.examen.utils.ReflectionUtils.getMonedaInstaceFromClassName;

@Service
public class CuentaCorrienteServiceImpl implements CuentaCorrienteService {
    @Autowired
    private CuentaCorrienteRepository repository;

    @Autowired
    private MovimientoService movimientoService;

    @Override
    public Page<CuentaCorriente> getAllCuentas(Integer page, Integer pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize));
    }

    @Override
    public Page<Movimiento> getMovsPorCuenta(String nro, Integer page, Integer pageSize){
        return repository.findMovsPorNroCC(nro,PageRequest.of(page, pageSize));
    }

    @Override
    public CuentaCorriente getCuenta(String nro){
        return repository.findByNro(nro);
    }

    @Override
    @Transactional
    public void crearYAgregarMovimiento(String nro, MovimientoDTO dto){
        CuentaCorriente cc = repository.findByNro(nro);
        Movimiento mov = movimientoService.createFromDTO(cc, dto);
        cc.agregarMovimiento(mov);
        repository.save(cc);
    }

    @Override
    public void deleteByNro(String nro) {
        if(contarMovimeintos(nro)>0){
            throw new ExcepcionAplicativo("La cuenta que trata de eliminar tiene movimientos.");
        } else {
            repository.deleteByNro(nro);
        }

    }

    @Override
    public void create(CuentaCorrienteDTO cc) {
        try {
            repository.save(new CuentaCorriente(new BigDecimal(cc.getSaldo())
                    , cc.getNro(), getMonedaInstaceFromClassName(cc.getMoneda())
            ));
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Integer contarMovimeintos(String nro){
        return repository.contarMovimientosDeCuenta(nro);
    }

    @Override
    public void editarCC(CuentaCorrienteDTO cc, String nro) {
        CuentaCorriente ccOld = repository.findByNro(nro);
        cambiarValorSiEsDiferente(ccOld, cc);
        repository.save(ccOld);
    }

    @Override
    public void actualizarCC(String nro, CuentaCorrienteDTO cc) {
        CuentaCorriente ccOld = repository.findByNro(nro);
        cambiarValor(ccOld, cc);
        repository.save(ccOld);
    }

    private void cambiarValor(CuentaCorriente ccOld, CuentaCorrienteDTO cc) {
            ccOld.setNro(cc.getNro());
            ccOld.setSaldo(new BigDecimal(cc.getSaldo() == null ? "0.00" : cc.getSaldo()));
            try {
                if( cc.getMoneda() != null ){
                    ccOld.setMoneda(getMonedaInstaceFromClassName(cc.getMoneda()));
                } else {
                    ccOld.setMoneda(null);
                }
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
    }

    private void cambiarValorSiEsDiferente(CuentaCorriente ccOld, CuentaCorrienteDTO cc) {
        //FIXME esto podria hacer con Fields para no tener tantos ifs pero termino comparando IDs y puede terminar en vulnerabilidad
        //Los movimientos no pueden cambiar por eso se queda fuera de este metodo
        if(!(cc.getNro() == null) && !cc.getNro().equals(ccOld.getNro())){
            ccOld.setNro(cc.getNro());
        }
        if(!(cc.getSaldo() == null) && !cc.getSaldo().equals(ccOld.getSaldo().toString())){
            ccOld.setSaldo(new BigDecimal(cc.getSaldo()));
        }
        if(!(cc.getMoneda() == null) && !cc.getMoneda().equals(ccOld.getMoneda().getClass().getName())){
            try {
                ccOld.setMoneda(getMonedaInstaceFromClassName(cc.getMoneda()));
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }


}
