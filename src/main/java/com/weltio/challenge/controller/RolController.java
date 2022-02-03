package com.weltio.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weltio.challenge.entity.Rol;
import com.weltio.challenge.service.RolService;

@RestController
@RequestMapping("/auth/rol")
public class RolController {
	
	@Autowired
	private RolService rolService;
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Rol rol){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(rolService.save(rol));
	}
	
}
