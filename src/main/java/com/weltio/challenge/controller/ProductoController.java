package com.weltio.challenge.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.weltio.challenge.entity.Orden;
import com.weltio.challenge.entity.Producto;
import com.weltio.challenge.service.OrdenService;
import com.weltio.challenge.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private OrdenService ordenService;
	
	private Orden ordenN;
	
	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> save(@RequestBody Producto producto){
		
//		ordenN = new Orden();
//		ordenN.setInicioDate(LocalDate.now());
		
//		if(!ordenService.existsByIdOrden(ordenN.getIdOrden())) {
//			ordenService.save(ordenN);
//			producto.setIdOrden(ordenN);
//		}
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(productoService.save(producto));
	}
	
	@GetMapping
	public ResponseEntity<List<Producto>> listAll(){
		try {
			List<Producto> productos = StreamSupport
					.stream(productoService.findAll().spliterator(), false)
					.collect(Collectors.toList());
			return new ResponseEntity(productos, HttpStatus.OK);
		} catch (BadRequest ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id){
		if(productoService.existsById(id)) {
			return new ResponseEntity("No existe", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(productoService.findById(id).get());
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody Producto producto){
		
		Optional<Producto> producto2 = productoService.findById(id);
		if(!producto2.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		producto2.get().setNombreProducto(producto.getNombreProducto());
		producto2.get().setCantidad(producto.getCantidad());
		producto2.get().setPrecioUnit(producto.getPrecioUnit());		
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(productoService.save(producto2.get()));
	}
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		
		productoService.delete(id);
		
		return ResponseEntity.ok().build();
	}
}
