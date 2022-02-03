package com.weltio.challenge.service;

import java.util.Optional;

import com.weltio.challenge.entity.Orden;

public interface OrdenService {
	
	Orden save(Orden orden);
	
	Iterable<Orden> findAll();
	
	Optional<Orden> findByIdOrden(String id);
	
	void delete(String id);
	
	Boolean existsByIdOrden(String id);
	
	Iterable<Orden> reporte();
}
