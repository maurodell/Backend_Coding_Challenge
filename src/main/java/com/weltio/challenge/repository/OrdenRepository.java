package com.weltio.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.weltio.challenge.entity.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, String>{
	
	@Query("SELECT p.nombreProducto, p.cantidad, o.precioTotal FROM Producto p INNER JOIN p.idOrden o "
			+ "WHERE o.idOrden = p.idOrden "
			+ "ORDER BY o.inicioDate")
	public Iterable<Orden> reporte();
}