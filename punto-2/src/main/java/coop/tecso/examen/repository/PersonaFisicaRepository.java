package coop.tecso.examen.repository;

import coop.tecso.examen.model.titular.PersonaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

//TO FIX --> usar un flag de activo para manejar bajas logicas
public interface PersonaFisicaRepository extends JpaRepository<PersonaFisica, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM PersonaFisica t WHERE t.RUT = :rut")
    void deleteByRUT(@Param("rut") String rut);

    @Query("SELECT pf FROM PersonaFisica pf WHERE pf.RUT=:rut")
    PersonaFisica findByRut(@Param("rut") String rut);
}