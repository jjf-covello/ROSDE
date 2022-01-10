package coop.tecso.examen.service.impl;

import coop.tecso.examen.dto.PersonaJuridicaDTO;
import coop.tecso.examen.model.PersonaJuridica;
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
    public void changeRUT(String rut, String newRut) {
        repository.changeRut(rut, newRut);
    }

    @Override
    public void create(PersonaJuridicaDTO persona) {
        repository.save(new PersonaJuridica(persona.getRazonSocial(), Date.valueOf(persona.getAnioFundacion()),
                persona.getRUT()));
    }

}
