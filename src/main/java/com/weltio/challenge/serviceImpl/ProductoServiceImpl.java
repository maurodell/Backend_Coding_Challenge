package com.weltio.challenge.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weltio.challenge.entity.Producto;
import com.weltio.challenge.repository.ProductoRepository;
import com.weltio.challenge.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Override
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public void delete(String id) {
		productoRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Producto> findAll() {
		return productoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Boolean existsById(String id) {
		return productoRepository.existsById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> findById(String id) {
		return productoRepository.findById(id);
	}

}
