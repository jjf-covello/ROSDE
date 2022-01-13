package coop.tecso.examen.repository;

import coop.tecso.examen.model.cc.CuentaCorriente;
import coop.tecso.examen.model.movimiento.Movimiento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CuentaCorrienteRepository extends JpaRepository<CuentaCorriente, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM CuentaCorriente cc WHERE cc.nro = :nro")
    void deleteByNro(@Param("nro") String nro);

    @Query("SELECT COUNT(mv) FROM CuentaCorriente cc LEFT JOIN cc.movimientos mv WHERE cc.nro = :nro")
    Integer contarMovimientosDeCuenta(@Param("nro") String nro);

    @Query("SELECT cc FROM CuentaCorriente cc WHERE cc.nro = :nro")
    CuentaCorriente findByNro(@Param("nro") String nro);

    @Query("SELECT mv FROM CuentaCorriente cc LEFT JOIN cc.movimientos mv WHERE cc.nro = :nro ORDER BY mv.fecha DESC")
    Page<Movimiento> findMovsPorNroCC(@Param("nro")String nro, Pageable page);
}
