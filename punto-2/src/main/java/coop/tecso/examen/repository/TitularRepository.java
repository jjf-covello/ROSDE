package coop.tecso.examen.repository;

import coop.tecso.examen.model.titular.Titular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TitularRepository extends JpaRepository<Titular, Long> {

    @Modifying
    @Query("DELETE FROM Titular t WHERE t.RUT = :rut")
    void deleteByRUT(@Param("rut") String rut);

    @Modifying
    @Query("UPDATE Titular SET RUT = :newRut WHERE RUT = :rut")
    void changeRut(@Param("rut") String rut, @Param("newRut") String newRut);
}
