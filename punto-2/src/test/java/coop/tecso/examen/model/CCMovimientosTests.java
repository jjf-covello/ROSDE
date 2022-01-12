package coop.tecso.examen.model;

import coop.tecso.examen.model.cc.CuentaCorriente;
import coop.tecso.examen.model.cc.moneda.Dolar;
import coop.tecso.examen.model.exception.ExcepcionAplicativo;
import coop.tecso.examen.model.movimiento.Movimiento;
import coop.tecso.examen.model.movimiento.tipo.Credito;
import coop.tecso.examen.model.movimiento.tipo.Debito;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
public class CCMovimientosTests {

    @Test
    public void AddACreditMoveToAccountTest() {
        CuentaCorriente cc = new CuentaCorriente(BigDecimal.ZERO,"78498108", new Dolar());
        cc.agregarMovimiento(new Movimiento(cc , new Date(), "movimiento de prueba - credito", new Credito(),
                BigDecimal.TEN));
        Assert.assertEquals(cc.getMovimientos().size(),1);
        Assert.assertEquals("10.00",cc.getSaldo().toString());
    }

    @Test
    public void AddADebitMoveToAccountTest() {
        CuentaCorriente cc = new CuentaCorriente(BigDecimal.ZERO,"78498108", new Dolar());
        cc.agregarMovimiento(new Movimiento(cc , new Date(), "movimiento de prueba - debito", new Debito(),
                BigDecimal.TEN));
        Assert.assertEquals(cc.getMovimientos().size(),1);
        Assert.assertEquals("-10.00",cc.getSaldo().toString());
    }

    @Test(expected = ExcepcionAplicativo.class)
    public void AddAInvalidDebitMoveToAccountTest() {
        CuentaCorriente cc = new CuentaCorriente(BigDecimal.ZERO,"78498108", new Dolar());
        cc.agregarMovimiento(new Movimiento(cc , new Date(), "movimiento de prueba - debito", new Debito(),
                new BigDecimal("1000.00")));
    }

    @Test
    public void AddASequenceMoveToAccountTest() {
        CuentaCorriente cc = new CuentaCorriente(BigDecimal.ZERO,"78498108", new Dolar());
        cc.agregarMovimiento(new Movimiento(cc , new Date(), "movimiento de prueba - credito 1", new Credito(),
                new BigDecimal("1000.00")));
        cc.agregarMovimiento(new Movimiento(cc , new Date(), "movimiento de prueba - credito 2", new Credito(),
                new BigDecimal("1400.00")));
        cc.agregarMovimiento(new Movimiento(cc , new Date(), "movimiento de prueba - debito 1", new Debito(),
                new BigDecimal("1500.00")));
        cc.agregarMovimiento(new Movimiento(cc , new Date(), "movimiento de prueba - credito 3", new Credito(),
                new BigDecimal("1000.00")));
        cc.agregarMovimiento(new Movimiento(cc , new Date(), "movimiento de prueba - debito 2", new Debito(),
                new BigDecimal("1000.00")));
        Assert.assertEquals(cc.getMovimientos().size(),5);
        Assert.assertEquals("900.00",cc.getSaldo().toString());
    }

    @Test(expected = ExcepcionAplicativo.class)
    public void AddAInvalidSequenceMoveToAccountTest() {
        CuentaCorriente cc = new CuentaCorriente(BigDecimal.ZERO,"78498108", new Dolar());
        cc.agregarMovimiento(new Movimiento(cc , new Date(), "movimiento de prueba - credito", new Credito(),
                new BigDecimal("1400.00")));
        cc.agregarMovimiento(new Movimiento(cc , new Date(), "movimiento de prueba - debito 1", new Debito(),
                new BigDecimal("1500.00")));
        cc.agregarMovimiento(new Movimiento(cc , new Date(), "movimiento de prueba - debito 1", new Debito(),
                new BigDecimal("1000.00")));
    }
}
