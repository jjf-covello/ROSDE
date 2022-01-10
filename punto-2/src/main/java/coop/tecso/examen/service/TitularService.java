package coop.tecso.examen.service;

import coop.tecso.examen.dto.TitularDTO;
import org.springframework.data.domain.Page;

public interface TitularService {
    Page<TitularDTO> getAllTitulars(Integer page, Integer pageSize);

    void deleteByRUT(String rut);

    void changeRUT(String rut, String newRut);
}
