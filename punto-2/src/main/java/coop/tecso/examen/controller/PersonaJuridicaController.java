package coop.tecso.examen.controller;

import coop.tecso.examen.dto.titular.PersonaJuridicaDTO;
import coop.tecso.examen.service.PersonaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/titular/personaJuridica")
public class PersonaJuridicaController {

    @Autowired
    private PersonaJuridicaService personaJuridicaService;

    @GetMapping("/")
    public ResponseEntity getAllPersonaJuridicas(@RequestParam Integer page, @RequestParam Integer pageSize) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    personaJuridicaService.getAllTitulars(page, pageSize));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Collections.singletonMap("Error", "Ocurrío un error, Intente nuevamente más tarde."));
        }
    }

    @PutMapping("/{rut}")
    public ResponseEntity putPersonaJuridica(@PathVariable("rut")String rut, @RequestBody Map<String, String> persona) {
        PersonaJuridicaDTO dto = obtenerDTODesdeMap(persona);
        try {
            personaJuridicaService.actualizar(rut, dto);
            return ResponseEntity.status(HttpStatus.OK).body(
                    Collections.singletonMap("Status: ", "200. Operación Completada"));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Collections.singletonMap("Error", "Ocurrío un error, Intente nuevamente más tarde."));
        }
    }
    @PostMapping("/")
    public ResponseEntity createPersonaJuridica(@RequestBody Map<String, String> persona) {
        PersonaJuridicaDTO dto = obtenerDTODesdeMap(persona);
        try {
            personaJuridicaService.create(dto);
            return ResponseEntity.status(HttpStatus.OK).body(
                    Collections.singletonMap("Status: ", "200. Operación Completada"));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Collections.singletonMap("Error", "Ocurrío un error, Intente nuevamente más tarde."));
        }
    }

    @DeleteMapping("/{rut}")
    public ResponseEntity deletePersonaJuridica(@PathVariable("rut") String rut) {

        try {
            personaJuridicaService.deleteByRUT(rut);
            return ResponseEntity.status(HttpStatus.OK).body(
                    Collections.singletonMap("Status: ", "200. Operación Completada"));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Collections.singletonMap("Error", "Ocurrío un error, Intente nuevamente más tarde."));
        }
    }

    @PatchMapping("/{rut}")
    public ResponseEntity patchPersonaJuridica(@PathVariable("rut")String rut, @RequestBody Map<String, String> persona) {

        PersonaJuridicaDTO dto = obtenerDTODesdeMap(persona);
        try {
            personaJuridicaService.modificar(rut, dto);
            return ResponseEntity.status(HttpStatus.OK).body(
                    Collections.singletonMap("Status: ", "200. Operación Completada"));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Collections.singletonMap("Error", "Ocurrío un error, Intente nuevamente más tarde."));
        }
    }

    private PersonaJuridicaDTO obtenerDTODesdeMap(Map<String, String> persona) {
        return new PersonaJuridicaDTO(
                persona.get("razonSocial"),
                persona.get("anioFundacion"),
                persona.get("RUT"));
    }
}
