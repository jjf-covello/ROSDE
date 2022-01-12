package coop.tecso.examen.repository;

import coop.tecso.examen.model.movimiento.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
}
