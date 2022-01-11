package coop.tecso.examen.repository;

import coop.tecso.examen.model.titular.PersonaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface PersonaFisicaRepository extends JpaRepository<PersonaFisica, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM PersonaFisica t WHERE t.RUT = :rut")
    void deleteByRUT(@Param("rut") String rut);

    @Modifying
    @Transactional
    @Query("UPDATE PersonaFisica SET RUT = :newRut WHERE RUT = :rut")
    void changeRut(@Param("rut") String rut, @Param("newRut") String newRut);

}