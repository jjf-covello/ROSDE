package coop.tecso.examen.repository;

import coop.tecso.examen.model.PersonaFisica;
import coop.tecso.examen.model.Titular;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonaFisicaRepository extends JpaRepository<PersonaFisica, Long> {

    @Modifying
    @Query("DELETE FROM PersonaFisica t WHERE t.RUT = :rut")
    void deleteByRUT(@Param("rut") String rut);

    @Modifying
    @Query("UPDATE PersonaFisica SET RUT = :newRut WHERE RUT = :rut")
    void changeRut(@Param("rut") String rut, @Param("newRut") String newRut);

}