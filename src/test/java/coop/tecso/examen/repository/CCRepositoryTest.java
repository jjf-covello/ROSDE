package coop.tecso.examen.repository;

import coop.tecso.examen.model.cc.CuentaCorriente;
import coop.tecso.examen.model.cc.moneda.Dolar;
import coop.tecso.examen.model.cc.moneda.Euro;
import coop.tecso.examen.model.cc.moneda.Moneda;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CCRepositoryTest {


    @Autowired
    private CuentaCorrienteRepository ccRepository;

    @Before
    public void setUp() {
        CuentaCorriente cc = new CuentaCorriente(BigDecimal.ZERO,"78498108", new Dolar());
        ccRepository.save(cc);
    }

    @Test
    public void findAllMustReturnAllAccounts() {
        List<CuentaCorriente> result = ccRepository.findAll();
        assertEquals(1, result.size());
        assertEquals(1, result.size());
    }

    @Test (expected = DataIntegrityViolationException.class)
    public void CantSaveAnotherUserWithSameNro() {
        CuentaCorriente cc = new CuentaCorriente(BigDecimal.TEN,"78498108", new Euro());
        ccRepository.save(cc);
    }

    @Test
    public void CanSaveAnotherUserWithSameAttributes() {
        CuentaCorriente cc = new CuentaCorriente(BigDecimal.TEN,"78498109", new Euro());
        ccRepository.save(cc);
    }
    
}
