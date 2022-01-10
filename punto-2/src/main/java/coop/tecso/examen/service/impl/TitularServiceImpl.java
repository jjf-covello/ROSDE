package coop.tecso.examen.service.impl;

import coop.tecso.examen.dto.TitularDTO;
import coop.tecso.examen.repository.TitularRepository;
import coop.tecso.examen.service.TitularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TitularServiceImpl implements TitularService {
    @Autowired
    private TitularRepository repository;

    @Override
    public Page<TitularDTO> getAllTitulars(Integer page, Integer pageSize) {
        Pageable pageRequest = PageRequest.of(page, pageSize);
        return repository.findAll(pageRequest).map(TitularDTO::GenerateFrom);
    }

    @Override
    public void deleteByRUT(String rut) {
        repository.deleteByRUT(rut);
    }

    @Override
    public void changeRUT(String rut, String newRut) {
        repository.changeRut(rut, newRut);
    }

}
