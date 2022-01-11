package coop.tecso.examen.controller;

import coop.tecso.examen.dto.TitularDTO;
import coop.tecso.examen.service.TitularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/titular")
public class TitularController {

    @Autowired
    private TitularService titularService;

    @GetMapping("/")
    public Page<TitularDTO> getAllTitulares(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return titularService.getAllTitulars(Math.max(0,page-1), Math.max(1, pageSize));
    }

    @PutMapping("/:rut")
    public void putTitular(@RequestParam("rut")String rut, @RequestParam("newRut")String newRut) {
        titularService.changeRUT(rut, newRut);
    }

    @DeleteMapping("/:rut")
    public void deleteTitular(@RequestParam String rut) {
        titularService.deleteByRUT(rut);
    }

    @PatchMapping("/:rut")
    public void patchtitular(@RequestParam("rut")String rut, @RequestParam("newRut")String newRut) {
        titularService.changeRUT(rut, newRut);
    }
}
