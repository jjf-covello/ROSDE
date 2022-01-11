package coop.tecso.examen.service;

import coop.tecso.examen.dto.PersonaFisicaDTO;
import coop.tecso.examen.dto.TitularDTO;
import org.springframework.data.domain.Page;

public interface PersonaFisicaService {
    Page<PersonaFisicaDTO> getAllTitulars(Integer page, Integer pageSize);

    void deleteByRUT(String rut);

    void changeRUT(String rut, String newRut);

    void create(PersonaFisicaDTO persona);
}