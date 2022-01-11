package coop.tecso.examen.controller;

import coop.tecso.examen.dto.movimientos.CuentaCorrienteDTO;
import coop.tecso.examen.dto.titular.PersonaFisicaDTO;
import coop.tecso.examen.model.exception.ExcepcionAplicativo;
import coop.tecso.examen.service.CuentaCorrienteService;
import coop.tecso.examen.service.PersonaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cc")
public class CuentaCorrienteController {

    @Autowired
    private CuentaCorrienteService cuentaCorrienteService;

    @GetMapping("/")
    public Page<CuentaCorrienteDTO> getAllCuentas(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return cuentaCorrienteService.getAllCuentas(page, pageSize).map(CuentaCorrienteDTO::GenerateFrom);
    }

    @PutMapping("/:rut")
    public void putCC(@RequestParam("nro") String nro, @RequestParam("cc") CuentaCorrienteDTO cc) {
        cuentaCorrienteService.actualizarCC(nro, cc);
    }

    @DeleteMapping("/:nro")
    public void deleteCC(@RequestParam String nro) {
        cuentaCorrienteService.deleteByNro(nro);
    }

    @PatchMapping("/:nro")
    public void patchPersonaFisica(@RequestParam("nro") String nro, @RequestParam("cc") CuentaCorrienteDTO cc) {
        cuentaCorrienteService.editarCC(cc, nro);
    }

    @PostMapping("/")
    public void createCC(@RequestParam("cc") CuentaCorrienteDTO cc) {
        cuentaCorrienteService.create(cc);
    }
}
