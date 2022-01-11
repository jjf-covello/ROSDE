package coop.tecso.examen.dto.movimientos;

import coop.tecso.examen.model.movimiento.Movimiento;

public class MovimientoDTO {

    private String fecha;
    private String descripcion;
    private String tipoMovimiento;
    private String importe;

    public MovimientoDTO(String fecha, String descripcion, String tipoMovimiento, String importe) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.tipoMovimiento = tipoMovimiento;
        this.importe = importe;
    }

    public MovimientoDTO() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public static MovimientoDTO GenerateFrom(Movimiento mov) {
        return new MovimientoDTO(mov.getFecha().toString(),
                mov.getDescripcion(),
                mov.getTipoMovimiento()
                        .getClass()
                        .getName(),
                mov.getImporte().toString()
        );
    }
}
