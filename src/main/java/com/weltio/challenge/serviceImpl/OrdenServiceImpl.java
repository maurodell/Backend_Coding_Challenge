package com.weltio.challenge.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weltio.challenge.entity.Orden;
import com.weltio.challenge.repository.OrdenRepository;
import com.weltio.challenge.service.OrdenService;

@Service
public class OrdenServiceImpl implements OrdenService{
	
	@Autowired
	OrdenRepository ordenRepository;
	

	
	@Override
	public Orden save(Orden orden) {
		return ordenRepository.save(orden);
	}

	@Override
	public void delete(String id) {
		ordenRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Orden> findAll() {
		return ordenRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Orden> findByIdOrden(String id) {
		return ordenRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Boolean existsByIdOrden(String id) {
		return ordenRepository.existsById(id);
	}

	@Override
	public Iterable<Orden> reporte() {
		return ordenRepository.reporte();
	}

}
