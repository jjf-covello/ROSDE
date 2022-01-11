package coop.tecso.examen.dto.movimientos;

import coop.tecso.examen.model.cc.CuentaCorriente;

import java.util.List;
import java.util.stream.Collectors;

public class CuentaCorrienteDTO {

    private List<MovimientoDTO> movimientos;
    private String saldo;
    private String nro;
    private String moneda;

    public CuentaCorrienteDTO() {
    }

    public CuentaCorrienteDTO(List<MovimientoDTO> movimientos, String saldo, String nro, String moneda) {
        this.movimientos = movimientos;
        this.saldo = saldo;
        this.nro = nro;
        this.moneda = moneda;
    }

    public CuentaCorrienteDTO(String saldo, String nro, String moneda) {
        this.saldo = saldo;
        this.nro = nro;
        this.moneda = moneda;
    }

    public List<MovimientoDTO> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<MovimientoDTO> movimientos) {
        this.movimientos = movimientos;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
    public static CuentaCorrienteDTO GenerateFrom(CuentaCorriente cc) {
        return new CuentaCorrienteDTO(
                cc.getMovimientos()
                        .stream()
                        .map(MovimientoDTO::GenerateFrom)
                        .collect(Collectors.toList()),
                cc.getSaldo().toString(),
                cc.getNro(),
                cc.getMoneda().getClass().getName()
        );
    }
}
