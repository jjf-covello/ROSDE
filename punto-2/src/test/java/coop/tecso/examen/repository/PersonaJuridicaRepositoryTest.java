package coop.tecso.examen.repository;

import coop.tecso.examen.model.Country;
import coop.tecso.examen.model.titular.PersonaFisica;
import coop.tecso.examen.model.titular.PersonaJuridica;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonaJuridicaRepositoryTest {


    @Autowired
    private PersonaJuridicaRepository personaJuridicaRepository;

    @Before
    public void setUp() {
        PersonaJuridica pj = new PersonaJuridica("PersonaJuridica 1", new Date(), "871976");
        personaJuridicaRepository.save(pj);
    }

    @Test
    public void findAllMustReturnAllPersons() {
        List<PersonaJuridica> result = personaJuridicaRepository.findAll();
        assertEquals(1, result.size());
        assertEquals(1, result.size());
    }

    @Test (expected = DataIntegrityViolationException.class)
    public void CantSaveAnotherUserWithSameRUT() {
        PersonaJuridica pj = new PersonaJuridica("PersonaJuridica 1", new Date(), "871976");
        personaJuridicaRepository.save(pj);
    }

    @Test
    public void CanSaveAnotherUserWithSameAttributes() {
        PersonaJuridica pj = new PersonaJuridica("PersonaJuridica 1", new Date(), "871999");
        personaJuridicaRepository.save(pj);
    }
    
}
