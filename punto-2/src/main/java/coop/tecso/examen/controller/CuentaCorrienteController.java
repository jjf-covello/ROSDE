package coop.tecso.examen.controller;

import coop.tecso.examen.dto.movimientos.CuentaCorrienteDTO;
import coop.tecso.examen.dto.titular.PersonaFisicaDTO;
import coop.tecso.examen.model.exception.ExcepcionAplicativo;
import coop.tecso.examen.service.CuentaCorrienteService;
import coop.tecso.examen.service.PersonaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/cc")
public class CuentaCorrienteController {

    @Autowired
    private CuentaCorrienteService cuentaCorrienteService;

    @GetMapping("")
    public ResponseEntity<Object> getAllCuentas(@RequestParam Integer page,
                                                @RequestParam Integer pageSize) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    cuentaCorrienteService.getAllCuentas(page, pageSize).map(CuentaCorrienteDTO::GenerateFrom));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Collections.singletonMap("Error", "Ocurrío un error, Intente nuevamente más tarde."));
        }
    }

    @PutMapping("/{nro}")
    public ResponseEntity putCC(@PathVariable(value = "nro") String nro,
                                @RequestBody Map<String, String> cc) {
        try {
            CuentaCorrienteDTO dto = obtenerDTODesdeMap(cc);
            cuentaCorrienteService.actualizarCC(nro, dto);
            return ResponseEntity.status(HttpStatus.OK).body(
                    Collections.singletonMap("Status: ", "200. Operación Completada"));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Collections.singletonMap("Error", "Ocurrío un error, Intente nuevamente más tarde."));
        }
    }

    @DeleteMapping("/{nro}")
    public ResponseEntity deleteCC(@PathVariable(value = "nro") String nro) {
        try {
            cuentaCorrienteService.deleteByNro(nro);
            return ResponseEntity.status(HttpStatus.OK).body(
                    Collections.singletonMap("Status: ", "200. Operación Completada"));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Collections.singletonMap("Error", "Ocurrío un error, Intente nuevamente más tarde."));
        }
    }

    @PatchMapping("/{nro}")
    public ResponseEntity patchCC(@PathVariable(value = "nro") String nro,
                                  @RequestBody Map<String, String> cc) {
        try {
            CuentaCorrienteDTO dto = obtenerDTODesdeMap(cc);
            cuentaCorrienteService.editarCC(dto, nro);
            return ResponseEntity.status(HttpStatus.OK).body(
                    Collections.singletonMap("Status: ", "200. Operación Completada"));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Collections.singletonMap("Error", "Ocurrío un error, Intente nuevamente más tarde."));
        }
    }

    @PostMapping("/")
    public ResponseEntity createCC(@RequestBody Map<String, String> cc) {
        try {
            CuentaCorrienteDTO dto = obtenerDTODesdeMap(cc);
            cuentaCorrienteService.create(dto);
            return ResponseEntity.status(HttpStatus.OK).body(
                    Collections.singletonMap("Status: ", "200. Operación Completada"));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Collections.singletonMap("Error", "Ocurrío un error, Intente nuevamente más tarde."));
        }
    }

    private CuentaCorrienteDTO obtenerDTODesdeMap(Map<String, String> cc) {
        return new CuentaCorrienteDTO(
                cc.get("saldo"),
                cc.get("nro"),
                cc.get("moneda"));
    }
}
