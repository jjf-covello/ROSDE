package coop.tecso.examen.service.impl;

import coop.tecso.examen.dto.movimientos.CuentaCorrienteDTO;
import coop.tecso.examen.model.cc.CuentaCorriente;
import coop.tecso.examen.model.cc.moneda.Moneda;
import coop.tecso.examen.model.exception.ExcepcionAplicativo;
import coop.tecso.examen.repository.CuentaCorrienteRepository;
import coop.tecso.examen.service.CuentaCorrienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import static coop.tecso.examen.utils.ReflectionUtils.getInstaceFromClassName;

public class CuentaCorrienteServiceImpl implements CuentaCorrienteService {
    @Autowired
    private CuentaCorrienteRepository repository;

    @Override
    public Page<CuentaCorriente> getAllCuentas(Integer page, Integer pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize));
    }

    @Override
    public void deleteByNro(String nro) {
        if(contarMovimeintos(nro)>0){
            repository.deleteByNro(nro);
        } else {
            throw new ExcepcionAplicativo("La cuenta que trata de eliminar tiene movimientos.");
        }

    }

    @Override
    public void create(CuentaCorrienteDTO cc) {
        try {
            repository.save(new CuentaCorriente(new BigDecimal(cc.getSaldo())
                    , cc.getNro(), (Moneda) getInstaceFromClassName(cc.getMoneda())
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
            ccOld.setSaldo(new BigDecimal(cc.getSaldo()));
            try {
                ccOld.setMoneda((Moneda) getInstaceFromClassName(cc.getMoneda()));
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
    }

    private void cambiarValorSiEsDiferente(CuentaCorriente ccOld, CuentaCorrienteDTO cc) {
        //FIXME esto podria hacer con Fields para no tener tantos ifs pero termino comparando IDs y puede terminar en vulnerabilidad
        //Los movimientos no pueden cambiar por eso se queda fuera de este metodo
        if(!cc.getNro().equals(ccOld.getNro())){
            ccOld.setNro(cc.getNro());
        }
        if(!cc.getSaldo().equals(ccOld.getSaldo().toString())){
            ccOld.setSaldo(new BigDecimal(cc.getSaldo()));
        }
        if(!cc.getMoneda().equals(ccOld.getMoneda().getClass().getName())){
            try {
                ccOld.setMoneda((Moneda) getInstaceFromClassName(cc.getMoneda()));
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }


}
