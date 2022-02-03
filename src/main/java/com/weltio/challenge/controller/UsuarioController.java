package com.weltio.challenge.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.weltio.challenge.dto.UsuarioDTO;
import com.weltio.challenge.entity.Usuario;
import com.weltio.challenge.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody UsuarioDTO usuarioDTO){
		
		if(usuarioService.existsByEmail(usuarioDTO.getEmail())) {
			return new ResponseEntity("Este email ya existe", HttpStatus.BAD_REQUEST);
		}
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.save(usuarioDTO));
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listAll(){
		try {
			List<Usuario> usuarios = StreamSupport
					.stream(usuarioService.findAll().spliterator(), false)
					.collect(Collectors.toList());
			return new ResponseEntity(usuarios, HttpStatus.OK);
		} catch (BadRequest ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{email}")
	public ResponseEntity<?> upload(@RequestBody UsuarioDTO usuarioDTO, @PathVariable(value = "email") String email){
		if(!usuarioService.existsByEmail(usuarioDTO.getEmail())) {
			return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
		}
		
		UsuarioDTO usuarioDTO2 = usuarioService.findByEmail(email);
		usuarioDTO2.setNombre(usuarioDTO.getNombre());
		usuarioDTO2.setPassword(usuarioDTO.getPassword());
		usuarioDTO2.setHabilitado(usuarioDTO.getHabilitado());
		return ResponseEntity.status(HttpStatus.OK)
				.body(usuarioService.save(usuarioDTO2));
	}
	
	@GetMapping("/habilidatos")
	public ResponseEntity<List<Usuario>> findAllHabilidatos(){
		try {
			List<Usuario> usuarios = StreamSupport
					.stream(usuarioService.findAllHabilitado().spliterator(), false)
					.collect(Collectors.toList());
			return new ResponseEntity(usuarios, HttpStatus.OK);
		} catch (BadRequest ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
