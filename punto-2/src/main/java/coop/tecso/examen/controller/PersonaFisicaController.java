package coop.tecso.examen.controller;

import coop.tecso.examen.dto.titular.PersonaFisicaDTO;
import coop.tecso.examen.service.PersonaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/titular/personaFisica")
public class PersonaFisicaController {

    @Autowired
    private PersonaFisicaService personaFisicaService;

    @GetMapping("")
    public Page<PersonaFisicaDTO> getAllPersonaFisicas(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return personaFisicaService.getAllTitulars(page, pageSize);
    }

    @PutMapping("/{rut}")
    public void putPersonaFisica(@PathVariable("rut")String rut, @RequestParam("newRut")String newRut) {
        personaFisicaService.changeRUT(rut, newRut);
    }

    @DeleteMapping("/{rut}")
    public void deletePersonaFisica(@PathVariable String rut) {
        personaFisicaService.deleteByRUT(rut);
    }

    @PatchMapping("/{rut}")
    public void patchPersonaFisica(@PathVariable("rut")String rut, @RequestParam("newRut")String newRut) {
        personaFisicaService.changeRUT(rut, newRut);
    }

    @PostMapping("/")
    public void createPersonaFisica(@RequestParam("personaJuridica") PersonaFisicaDTO persona) {
        personaFisicaService.create(persona);
    }
}
