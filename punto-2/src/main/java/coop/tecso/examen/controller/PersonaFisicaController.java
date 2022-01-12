package coop.tecso.examen.controller;

import coop.tecso.examen.dto.titular.PersonaFisicaDTO;
import coop.tecso.examen.service.PersonaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/titular/personaFisica")
public class PersonaFisicaController {

    @Autowired
    private PersonaFisicaService personaFisicaService;

    @GetMapping("")
    public ResponseEntity getAllPersonaFisicas(@RequestParam Integer page, @RequestParam Integer pageSize) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    personaFisicaService.getAllTitulars(page, pageSize));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Collections.singletonMap("Error", "Ocurrío un error, Intente nuevamente más tarde."));
        }
    }

    @PutMapping("/{rut}")
    public ResponseEntity putPersonaFisica(@PathVariable("rut")String rut, @RequestBody Map<String, String> persona) {

        PersonaFisicaDTO dto = obtenerDTODesdeMap(persona);
        try {
            personaFisicaService.modificar(rut, dto);
            return ResponseEntity.status(HttpStatus.OK).body(
                    Collections.singletonMap("Status: ", "200. Operación Completada"));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Collections.singletonMap("Error", "Ocurrío un error, Intente nuevamente más tarde."));
        }
    }

    @DeleteMapping("/{rut}")
    public ResponseEntity deletePersonaFisica(@PathVariable String rut) {

        try {
            personaFisicaService.deleteByRUT(rut);
            return ResponseEntity.status(HttpStatus.OK).body(
                    Collections.singletonMap("Status: ", "200. Operación Completada"));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Collections.singletonMap("Error", "Ocurrío un error, Intente nuevamente más tarde."));
        }

    }

    @PatchMapping("/{rut}")
    public ResponseEntity patchPersonaFisica(@PathVariable("rut")String rut, @RequestBody Map<String, String> persona) {

        PersonaFisicaDTO dto = obtenerDTODesdeMap(persona);
        try {
            personaFisicaService.modificarSiHayCambios(rut, dto);
            return ResponseEntity.status(HttpStatus.OK).body(
                    Collections.singletonMap("Status: ", "200. Operación Completada"));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Collections.singletonMap("Error", "Ocurrío un error, Intente nuevamente más tarde."));
        }
    }

    @PostMapping("/")
    public ResponseEntity createPersonaFisica(@RequestBody Map<String, String> persona) {

        PersonaFisicaDTO dto = obtenerDTODesdeMap(persona);
        try {
            personaFisicaService.create(dto);
            return ResponseEntity.status(HttpStatus.OK).body(
                    Collections.singletonMap("Status: ", "200. Operación Completada"));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Collections.singletonMap("Error", "Ocurrío un error, Intente nuevamente más tarde."));
        }
    }

    private PersonaFisicaDTO obtenerDTODesdeMap(Map<String, String> persona) {
        return new PersonaFisicaDTO(
                persona.get("rut"),
                persona.get("nombre"),
                persona.get("apellido"),
                persona.get("cc")
        );
    }
}
