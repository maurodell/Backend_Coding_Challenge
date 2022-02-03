package com.weltio.challenge.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.weltio.challenge.controller.UsuarioController;
import com.weltio.challenge.dto.UsuarioDTO;
import com.weltio.challenge.entity.Usuario;
import com.weltio.challenge.service.UsuarioService;

public class UsuarioControllerTest {
	
	@InjectMocks
	UsuarioController usuarioController;
	
	@Mock
	private UsuarioService usuarioService;
	
	private Usuario usuario1;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		
		usuario1 = new Usuario();
		usuario1.setEmail("delloliomauro@gmail.com");
		usuario1.setNombre("Mauro");
		usuario1.setPassword("1234");
	}
	
	
	@Test
	public void crearTest() {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setEmail("delloliomauro@gmail.com");
		usuario.setNombre("Mauro");
		usuario.setPassword("1234");
		
		when(usuarioService.save(any(UsuarioDTO.class))).thenReturn(usuario);
		
		assertNotNull(usuarioController.save(usuario));
		
	}
	
	@Test
	public void findAllTest() {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		when(usuarioService.findAll()).thenReturn(Arrays.asList(usuario1));
		
		assertNotNull(usuarioController.listAll());
	}
	
	@Test
	public void existsByEmailTest() {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		when(usuarioService.existsByEmail("delloliomauro@gmail")).thenReturn(true);
		
		assertTrue(usuarioService.existsByEmail("delloliomauro@gmail"));
	}
	
	@Test
	public void uploadTest() {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		
		UsuarioDTO usuario3 = new UsuarioDTO();
		usuario3.setEmail("ana@gmail.com");
		usuario3.setNombre("Ana");
		usuario3.setPassword("1234");
		
		when(usuarioService.upload(any(UsuarioDTO.class))).thenReturn(usuario3);
		
		assertNotNull(usuarioController.upload(usuario3, "delloliomauro@gmail"));
	}
}
