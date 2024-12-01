package com.agendapro.product_demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.agendapro.product_demo.entities.Estadistica;

public interface EstadisticaRepository extends JpaRepository<Estadistica, Long> {

	@Query("SELECT e FROM Estadistica e ORDER BY e.fecha DESC")
	List<Estadistica> findEstadisticasByOrderByFechaDesc();
	
}
