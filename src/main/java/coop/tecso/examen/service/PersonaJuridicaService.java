package coop.tecso.examen.service;

import coop.tecso.examen.dto.titular.PersonaJuridicaDTO;
import org.springframework.data.domain.Page;

public interface PersonaJuridicaService {
    Page<PersonaJuridicaDTO> getAllTitulars(Integer page, Integer pageSize);

    void deleteByRUT(String rut);

    void create(PersonaJuridicaDTO persona);

    void actualizar(String rut, PersonaJuridicaDTO dto);

    void modificar(String rut, PersonaJuridicaDTO dto);
}
