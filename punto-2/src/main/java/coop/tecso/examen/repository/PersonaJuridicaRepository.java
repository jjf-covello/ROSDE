package coop.tecso.examen.repository;

import coop.tecso.examen.model.titular.PersonaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonaJuridicaRepository extends JpaRepository<PersonaJuridica, Long> {

    @Modifying
    @Query("DELETE FROM PersonaJuridica t WHERE t.RUT = :rut")
    void deleteByRUT(@Param("rut") String rut);

    @Modifying
    @Query("UPDATE PersonaJuridica SET RUT = :newRut WHERE RUT = :rut")
    void changeRut(@Param("rut") String rut, @Param("newRut") String newRut);
}
