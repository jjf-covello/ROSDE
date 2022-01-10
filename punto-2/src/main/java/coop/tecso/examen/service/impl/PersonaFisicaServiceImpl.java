package coop.tecso.examen.service.impl;

import coop.tecso.examen.dto.PersonaFisicaDTO;
import coop.tecso.examen.model.PersonaFisica;
import coop.tecso.examen.repository.PersonaFisicaRepository;
import coop.tecso.examen.service.PersonaFisicaService;
import org.aspectj.weaver.patterns.PerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonaFisicaServiceImpl implements PersonaFisicaService {
    @Autowired
    private PersonaFisicaRepository repository;

    @Override
    public Page<PersonaFisicaDTO> getAllTitulars(Integer page, Integer pageSize) {
        Pageable pageRequest = PageRequest.of(page, pageSize);
        return repository.findAll(pageRequest).map(PersonaFisicaDTO::GenerateFrom);
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
    public void create(PersonaFisicaDTO persona) {
        repository.save(new PersonaFisica(persona.getRUT(), persona.getApellido(), persona.getNombre(), persona.getCc()));
    }

}
