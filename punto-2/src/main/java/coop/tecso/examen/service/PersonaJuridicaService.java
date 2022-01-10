package coop.tecso.examen.service;

import coop.tecso.examen.dto.PersonaJuridicaDTO;
import org.springframework.data.domain.Page;

public interface PersonaJuridicaService {
    Page<PersonaJuridicaDTO> getAllTitulars(Integer page, Integer pageSize);

    void deleteByRUT(String rut);

    void changeRUT(String rut, String newRut);

    void create(PersonaJuridicaDTO persona);
}
