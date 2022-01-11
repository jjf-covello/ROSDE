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

    @GetMapping("/")
    public Page<CuentaCorrienteDTO> getAllCuentas(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return cuentaCorrienteService.getAllCuentas(page, pageSize).map(CuentaCorrienteDTO::GenerateFrom);
    }

    @PutMapping("/:nro")
    public void putCC(@RequestParam("nro") String nro, @RequestParam("cc") CuentaCorrienteDTO cc) {
        cuentaCorrienteService.actualizarCC(nro, cc);
    }

    @DeleteMapping("/:nro")
    public void deleteCC(@RequestParam("nro") String nro) {
        cuentaCorrienteService.deleteByNro(nro);
    }

    @PatchMapping("/:nro")
    public void patchCC(@RequestParam("nro") String nro, @RequestParam("cc") CuentaCorrienteDTO cc) {
        cuentaCorrienteService.editarCC(cc, nro);
    }

    @PostMapping("/")
    public void createCC(@RequestBody Map<String, String> cc) {
        cuentaCorrienteService.create(
                new CuentaCorrienteDTO(
                        cc.get("saldo"),
                        cc.get("nro"),
                        cc.get("moneda")
                )
        );
    }
}
