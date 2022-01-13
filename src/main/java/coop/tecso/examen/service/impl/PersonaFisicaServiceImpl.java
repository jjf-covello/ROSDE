package coop.tecso.examen.service.impl;

import coop.tecso.examen.dto.titular.PersonaFisicaDTO;
import coop.tecso.examen.model.cc.CuentaCorriente;
import coop.tecso.examen.model.titular.PersonaFisica;
import coop.tecso.examen.repository.PersonaFisicaRepository;
import coop.tecso.examen.service.PersonaFisicaService;
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
    public void modificarSiHayCambios(String rut, PersonaFisicaDTO nuevosDatos){
        PersonaFisica personaFisicaDesactualizada = repository.findByRut(rut);
        cambiarValorSiHayModificacion(personaFisicaDesactualizada, nuevosDatos);
        repository.save(personaFisicaDesactualizada);
    }

    private void cambiarValor(PersonaFisica personaFisicaDesactualizada, PersonaFisicaDTO nuevosDatos) {
        personaFisicaDesactualizada.setApellido(nuevosDatos.getApellido());
        personaFisicaDesactualizada.setNombre(nuevosDatos.getNombre());
        personaFisicaDesactualizada.setCC(nuevosDatos.getCc());
        personaFisicaDesactualizada.setRUT(nuevosDatos.getRUT());
    }

    @Override
    public void modificar(String rut, PersonaFisicaDTO nuevosDatos){
        PersonaFisica personaFisicaDesactualizada = repository.findByRut(rut);
        cambiarValor(personaFisicaDesactualizada, nuevosDatos);
        repository.save(personaFisicaDesactualizada);
    }

    private void cambiarValorSiHayModificacion(PersonaFisica personaFisicaDesactualizada, PersonaFisicaDTO nuevosDatos) {
        if(personaFisicaDesactualizada.getApellido()!= null &&
                !personaFisicaDesactualizada.getApellido().equals((nuevosDatos.getApellido()))){
            personaFisicaDesactualizada.setApellido(nuevosDatos.getApellido());
        }
        if(personaFisicaDesactualizada.getApellido()!= null &&
                !personaFisicaDesactualizada.getApellido().equals((nuevosDatos.getApellido()))) {
            personaFisicaDesactualizada.setApellido(nuevosDatos.getApellido());
        }

        if(personaFisicaDesactualizada.getNombre()!= null &&
                !personaFisicaDesactualizada.getNombre().equals((nuevosDatos.getNombre()))){
            personaFisicaDesactualizada.setNombre(nuevosDatos.getNombre());
        }

        if(personaFisicaDesactualizada.getCC()!= null &&
                !personaFisicaDesactualizada.getCC().equals((nuevosDatos.getCc()))) {
            personaFisicaDesactualizada.setCC(nuevosDatos.getCc());
        }

        if(personaFisicaDesactualizada.getRUT()!= null &&
                !personaFisicaDesactualizada.getRUT().equals((nuevosDatos.getRUT()))) {
            personaFisicaDesactualizada.setRUT(nuevosDatos.getRUT());
        }
    }

    @Override
    public void create(PersonaFisicaDTO persona) {
        repository.save(new PersonaFisica(persona.getRUT(), persona.getApellido(), persona.getNombre(), persona.getCc()));
    }

}
