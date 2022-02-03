package com.weltio.challenge.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.weltio.challenge.service.OrdenService;

@RestController
@RequestMapping("/auth/orden")
public class OrdenController {
	
	@Autowired
	private OrdenService ordenService;
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Orden orden){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ordenService.save(orden));
	}
	
	@GetMapping
	public ResponseEntity<List<Orden>> listAll(){
		try {
			List<Orden> ordenes = StreamSupport
					.stream(ordenService.findAll().spliterator(), false)
					.collect(Collectors.toList());
			return new ResponseEntity(ordenes, HttpStatus.OK);
		} catch (BadRequest ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/reporte")
	public ResponseEntity<List<Orden>> reporte(){
			List<Orden> reporte = StreamSupport
					.stream(ordenService.reporte().spliterator(), false)
					.collect(Collectors.toList());
			
			return new ResponseEntity(reporte, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id){
		if(ordenService.existsByIdOrden(id)) {
			return new ResponseEntity("No existe", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(ordenService.findByIdOrden(id).get());
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody Orden orden){
		
		Optional<Orden> orden2 = ordenService.findByIdOrden(id);
		if(!orden2.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		orden2.get().setFinDate(orden.getFinDate());
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(ordenService.save(orden2.get()));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		
		ordenService.delete(id);
		
		return ResponseEntity.ok().build();
	}
}
