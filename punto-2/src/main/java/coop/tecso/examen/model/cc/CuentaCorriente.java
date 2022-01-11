package coop.tecso.examen.model.cc;

import coop.tecso.examen.model.AbstractPersistentObject;
import coop.tecso.examen.model.cc.moneda.Moneda;
import coop.tecso.examen.model.movimiento.Movimiento;
import coop.tecso.examen.utils.converters.ClazzConverter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cuenta_corriente")
public class CuentaCorriente extends AbstractPersistentObject {

    @OneToMany(mappedBy = "cuentaCorriente")
    private List<Movimiento> movimientos;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "numero_cuenta", unique = true, nullable = false)
    private String nro;

    @Convert(converter = MonedaConverter.class)
    private Moneda moneda;

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public void agregarMovimiento(Movimiento mov) {
        getMoneda().verificarGiro(this,mov);
        mov.aplicar(this,mov);
        this.movimientos.add(mov);
    }

    public CuentaCorriente() {
    }

    public CuentaCorriente(List<Movimiento> movimientos, BigDecimal saldo, String nro, Moneda moneda) {
        this.movimientos = movimientos;
        this.saldo = saldo;
        this.nro = nro;
        this.moneda = moneda;
    }

    public CuentaCorriente(BigDecimal saldo, String nro, Moneda moneda) {
        this.saldo = saldo;
        this.nro = nro;
        this.moneda = moneda;
        this.movimientos = new ArrayList<>();
    }

    private static class MonedaConverter extends ClazzConverter<Moneda> {

    }
}
