package coop.tecso.examen.repository;

import coop.tecso.examen.model.titular.PersonaFisica;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonaFisicaRepositoryTest {


    @Autowired
    private PersonaFisicaRepository personaFisicaRepository;
    
    @Before
    public void setUp() {
        PersonaFisica pf = new PersonaFisica("7893791", "Covello","Jorge", "871876");
        personaFisicaRepository.save(pf);
    }
        
    @Test
    public void findAllMustReturnAllPersons() {
    	List<PersonaFisica> result = personaFisicaRepository.findAll();
    	assertEquals(1, result.size());
        assertEquals(1, result.size());
    }

    @Test (expected = DataIntegrityViolationException.class)
    public void CantSaveAnotherUserWithSameRUT() {
        PersonaFisica pf = new PersonaFisica("7893791", "Covello","Julio", "871976");
        personaFisicaRepository.save(pf);
    }

    @Test
    public void CanSaveAnotherUserWithSameAttributes() {
        PersonaFisica pf = new PersonaFisica("7893792", "Covello","Jorge", "871976");
        personaFisicaRepository.save(pf);
    }
    
}
