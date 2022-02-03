package com.weltio.challenge.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.weltio.challenge.controller.OrdenController;
import com.weltio.challenge.controller.ProductoController;
import com.weltio.challenge.entity.Orden;
import com.weltio.challenge.entity.Producto;
import com.weltio.challenge.service.ProductoService;

public class ProductoControllerTest {

	@InjectMocks
	ProductoController productoController;
	
	@InjectMocks
	OrdenController ordenController;
	
	@Mock
	private ProductoService productoService;
	
	private Producto producto;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		
		producto = new Producto();
		producto.setNombreProducto("Producto1");
		producto.setPrecioUnit(120);
		producto.setCantidad(5);
	}
	
	@Test
	public void crearTest() {
		
		Orden orden = new Orden();
		orden.setInicioDate(LocalDate.now());
		orden.setIdOrden("1");
		
		Producto producto2 = new Producto();
		producto2.setNombreProducto("Producto1");
		producto2.setPrecioUnit(120);
		producto2.setCantidad(5);
		producto2.setIdOrden(orden);
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		when(productoService.save(any(Producto.class))).thenReturn(producto2);

		assertNotNull(productoController.save(producto2));
	}
	
	@Test
	public void listAllTest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		when(productoService.findAll()).thenReturn(Arrays.asList(producto));
		
		assertNotNull(productoController.listAll());
	}
	
	@Test
	public void findByIdTest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		when(productoService.findById(producto.getId())).thenReturn(Optional.of(producto));
		
		assertNotNull(productoController.findById(producto.getId()));
	}
}
