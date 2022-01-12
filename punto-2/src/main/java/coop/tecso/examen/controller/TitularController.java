package coop.tecso.examen.controller;

import coop.tecso.examen.service.TitularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/titular")
public class TitularController {

    @Autowired
    private TitularService titularService;

    @GetMapping("/")
    public ResponseEntity getAllTitulares(@RequestParam Integer page, @RequestParam Integer pageSize) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    titularService.getAllTitulars(Math.max(0,page-1), Math.max(1, pageSize)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Collections.singletonMap("Error", "Ocurrío un error, Intente nuevamente más tarde."));
        }
    }

    @PutMapping("/{rut}")
    public ResponseEntity putTitular(@PathVariable("rut")String rut, @RequestParam("newRut")String newRut) {
        try {
            titularService.changeRUT(rut, newRut);
            return ResponseEntity.status(HttpStatus.OK).body(
                    Collections.singletonMap("Status: ", "200. Operación Completada"));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Collections.singletonMap("Error", "Ocurrío un error, Intente nuevamente más tarde."));
        }
    }

    @DeleteMapping("/{rut}")
    public ResponseEntity deleteTitular(@PathVariable("rut") String rut) {

        try {
            titularService.deleteByRUT(rut);
            return ResponseEntity.status(HttpStatus.OK).body(
                    Collections.singletonMap("Status: ", "200. Operación Completada"));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Collections.singletonMap("Error", "Ocurrío un error, Intente nuevamente más tarde."));
        }
    }

    @PatchMapping("/{rut}")
    public ResponseEntity patchtitular(@PathVariable("rut")String rut, @RequestParam("newRut")String newRut) {
        try {
            titularService.changeRUT(rut, newRut);
            return ResponseEntity.status(HttpStatus.OK).body(
                    Collections.singletonMap("Status: ", "200. Operación Completada"));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Collections.singletonMap("Error", "Ocurrío un error, Intente nuevamente más tarde."));
        }
    }
}
