package coop.tecso.examen.model.movimiento;

import coop.tecso.examen.model.AbstractPersistentObject;
import coop.tecso.examen.model.cc.CuentaCorriente;
import coop.tecso.examen.model.movimiento.tipos.TipoMovimiento;
import coop.tecso.examen.utils.converters.nongeneric.TipoMovimientoConverter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "movimiento")
public class Movimiento extends AbstractPersistentObject {

    @ManyToOne
    private CuentaCorriente cuentaCorriente;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "descripcion",length = 200)
    private String descripcion;

    @Convert(converter = TipoMovimientoConverter.class)
    private TipoMovimiento tipoMovimiento;


    @Column(name = "importe", nullable= false, precision=7, scale=2)
    @Digits(integer=9, fraction=2)
    private BigDecimal importe;

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Movimiento(CuentaCorriente cuentaCorriente, Date fecha, String descripcion, TipoMovimiento tipoMovimiento,
                      BigDecimal importe) {
        this.cuentaCorriente = cuentaCorriente;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.tipoMovimiento = tipoMovimiento;
        this.importe = importe;
    }

    public Movimiento() {
    }

    public void aplicar(CuentaCorriente cuentaCorriente, Movimiento mov) {
        getTipoMovimiento().aplicarMovimiento(cuentaCorriente,mov);
    }
}
