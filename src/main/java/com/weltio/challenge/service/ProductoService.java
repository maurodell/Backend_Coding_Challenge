package com.weltio.challenge.service;

import java.util.Optional;

import com.weltio.challenge.entity.Producto;

public interface ProductoService {
	
	Producto save(Producto producto);
	
	void delete(String id);
	
	Iterable<Producto> findAll();
	
	Boolean existsById(String id);
	
	Optional<Producto> findById(String id);
}
