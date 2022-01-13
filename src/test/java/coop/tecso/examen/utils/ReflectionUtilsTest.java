package coop.tecso.examen.utils;

import coop.tecso.examen.model.cc.moneda.Moneda;
import coop.tecso.examen.model.movimiento.tipo.TipoMovimiento;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class ReflectionUtilsTest {

    @Test
    public void GetEuroClass() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Moneda euro = ReflectionUtils.getMonedaInstaceFromClassName("Euro");
        assertEquals(euro.getClass().getSimpleName(), "Euro");
    }
    @Test
    public void GetDolarClass() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Moneda dolar = ReflectionUtils.getMonedaInstaceFromClassName("Dolar");
        assertEquals(dolar.getClass().getSimpleName(), "Dolar");
    }

    @Test(expected = AssertionError.class)
    public void GetNonexistentMonedaClass() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Moneda prueba = ReflectionUtils.getMonedaInstaceFromClassName("Prueba");
    }

    @Test
    public void GetDebitoClass() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        TipoMovimiento mov = ReflectionUtils.getTipomovInstaceFromClassName("Debito");
        assertEquals(mov.getClass().getSimpleName(), "Debito");
    }

    @Test
    public void GetCreditoClass() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        TipoMovimiento mov = ReflectionUtils.getTipomovInstaceFromClassName("Credito");
        assertEquals(mov.getClass().getSimpleName(), "Credito");
    }

    @Test(expected = AssertionError.class)
    public void GetNonexistentMovClass() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        TipoMovimiento prueba = ReflectionUtils.getTipomovInstaceFromClassName("PruebaTipoMov");
    }
}
