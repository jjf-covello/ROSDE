package coop.tecso.examen.repository;

import coop.tecso.examen.model.titular.PersonaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface PersonaJuridicaRepository extends JpaRepository<PersonaJuridica, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM PersonaJuridica t WHERE t.RUT = :rut")
    void deleteByRUT(@Param("rut") String rut);

    @Query("SELECT pj FROM PersonaJuridica pj WHERE pj.RUT=:rut")
    PersonaJuridica findByRut(@Param("rut")String rut);
}
