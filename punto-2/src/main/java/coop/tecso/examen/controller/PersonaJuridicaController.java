package coop.tecso.examen.controller;

import com.fasterxml.jackson.databind.JsonNode;
import coop.tecso.examen.dto.titular.PersonaJuridicaDTO;
import coop.tecso.examen.service.PersonaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/titular/personaJuridica")
public class PersonaJuridicaController {

    @Autowired
    private PersonaJuridicaService personaJuridicaService;

    @GetMapping("/")
    public Page<PersonaJuridicaDTO> getAllPersonaJuridicas(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return personaJuridicaService.getAllTitulars(page, pageSize);
    }

    @PutMapping("/:rut")
    public void putPersonaJuridica(@RequestParam("rut")String rut, @RequestParam("newRut")String newRut) {
        personaJuridicaService.changeRUT(rut, newRut);
    }
    @PostMapping("/")
    public void createPersonaJuridica(@RequestBody JsonNode payload) {
        personaJuridicaService.create(new PersonaJuridicaDTO(
                payload.findValue("razonSocial").asText(),
                payload.findValue("anioFundacion").asText(),
                payload.findValue("RUT").asText()));
    }

    @DeleteMapping("/:rut")
    public void deletePersonaJuridica(@RequestParam String rut) {
        personaJuridicaService.deleteByRUT(rut);
    }

    @PatchMapping("/:rut")
    public void patchPersonaJuridica(@RequestParam("rut")String rut, @RequestParam("newRut")String newRut) {
        personaJuridicaService.changeRUT(rut, newRut);
    }
}
