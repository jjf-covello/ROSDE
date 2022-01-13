package coop.tecso.examen.service.impl;

import coop.tecso.examen.dto.titular.PersonaJuridicaDTO;
import coop.tecso.examen.model.titular.PersonaFisica;
import coop.tecso.examen.model.titular.PersonaJuridica;
import coop.tecso.examen.repository.PersonaJuridicaRepository;
import coop.tecso.examen.service.PersonaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class PersonaJuridicaServiceImpl implements PersonaJuridicaService {

    @Autowired
    private PersonaJuridicaRepository repository;

    @Override
    public Page<PersonaJuridicaDTO> getAllTitulars(Integer page, Integer pageSize) {
        Pageable pageRequest = PageRequest.of(page, pageSize);
        return repository.findAll(pageRequest).map(PersonaJuridicaDTO::GenerateFrom);
    }

    @Override
    public void deleteByRUT(String rut) {
        repository.deleteByRUT(rut);
    }

    @Override
    public void actualizar(String rut, PersonaJuridicaDTO nuevosDatos){
        PersonaJuridica JuridicaDesactualizada = repository.findByRut(rut);
        cambiarValor(JuridicaDesactualizada, nuevosDatos);
        repository.save(JuridicaDesactualizada);
    }

    private void cambiarValor(PersonaJuridica juridicaDesactualizada, PersonaJuridicaDTO nuevosDatos) {
        juridicaDesactualizada.setRazonSocial(nuevosDatos.getRazonSocial());
        juridicaDesactualizada.setAnioFundacion(Date.valueOf(nuevosDatos.getAnioFundacion()));
        juridicaDesactualizada.setRUT(nuevosDatos.getRUT());
    }

    @Override
    public void modificar(String rut, PersonaJuridicaDTO nuevosDatos){
        PersonaJuridica JuridicaDesactualizada = repository.findByRut(rut);
        cambiarValorSiHayModificacion(JuridicaDesactualizada, nuevosDatos);
        repository.save(JuridicaDesactualizada);
    }

    private void cambiarValorSiHayModificacion(PersonaJuridica juridicaDesactualizada, PersonaJuridicaDTO nuevosDatos) {
        if((juridicaDesactualizada.getRazonSocial()!=null) &&
                !(juridicaDesactualizada.getRazonSocial().equals(nuevosDatos.getRazonSocial()))){
            juridicaDesactualizada.setRazonSocial(nuevosDatos.getRazonSocial());
        }
        if((nuevosDatos.getAnioFundacion()!=null) &&
                !(Date.valueOf(nuevosDatos.getAnioFundacion()).equals(juridicaDesactualizada.getAnioFundacion()))){
            juridicaDesactualizada.setAnioFundacion(Date.valueOf(nuevosDatos.getAnioFundacion()));
        }
        if((juridicaDesactualizada.getRUT()!=null) &&
                !(juridicaDesactualizada.getRUT().equals(nuevosDatos.getRUT()))){
            juridicaDesactualizada.setRUT(nuevosDatos.getRUT());
        }
    }

    @Override
    public void create(PersonaJuridicaDTO persona) {
        repository.save(new PersonaJuridica(persona.getRazonSocial(), Date.valueOf(persona.getAnioFundacion()),
                persona.getRUT()));
    }

}
