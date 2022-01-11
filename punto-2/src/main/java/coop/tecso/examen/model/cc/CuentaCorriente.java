package coop.tecso.examen.model.cc;

import coop.tecso.examen.model.AbstractPersistentObject;
import coop.tecso.examen.model.movimiento.Movimiento;

import javax.persistence.*;
import java.math.BigDecimal;
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

    @Column(name="moneda")
    @Embedded
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
}
