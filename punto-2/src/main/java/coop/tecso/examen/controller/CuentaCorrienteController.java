package coop.tecso.examen.controller;

import coop.tecso.examen.dto.movimientos.CuentaCorrienteDTO;
import coop.tecso.examen.dto.titular.PersonaFisicaDTO;
import coop.tecso.examen.model.exception.ExcepcionAplicativo;
import coop.tecso.examen.service.CuentaCorrienteService;
import coop.tecso.examen.service.PersonaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/cc")
public class CuentaCorrienteController {

    @Autowired
    private CuentaCorrienteService cuentaCorrienteService;

    @GetMapping("")
    public Page<CuentaCorrienteDTO> getAllCuentas(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return cuentaCorrienteService.getAllCuentas(page, pageSize).map(CuentaCorrienteDTO::GenerateFrom);
    }

    @PutMapping("/{nro}")
    public void putCC(@PathVariable(value = "nro") String nro, @RequestBody Map<String, String> cc) {
        CuentaCorrienteDTO dto = obtenerDTODesdeMap(cc);
        cuentaCorrienteService.actualizarCC(nro, dto);
    }

    @DeleteMapping("/{nro}")
    public void deleteCC(@PathVariable(value = "nro") String nro) {
        cuentaCorrienteService.deleteByNro(nro);
    }

    @PatchMapping("/{nro}")
    public void patchCC(@PathVariable(value = "nro") String nro, @RequestBody Map<String, String> cc) {
        CuentaCorrienteDTO dto = obtenerDTODesdeMap(cc);
        cuentaCorrienteService.editarCC(dto, nro);
    }

    @PostMapping("/")
    public void createCC(@RequestBody Map<String, String> cc) {
        CuentaCorrienteDTO dto = obtenerDTODesdeMap(cc);
        cuentaCorrienteService.create(dto);
    }

    private CuentaCorrienteDTO obtenerDTODesdeMap(Map<String, String> cc) {
        return new CuentaCorrienteDTO(
                cc.get("saldo"),
                cc.get("nro"),
                cc.get("moneda"));
    }
}
