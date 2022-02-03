package com.weltio.challenge.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="orden")
public class Orden implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "idOrden", updatable = false, nullable = false)
	private String idOrden;
    
    @Column(name="inicioDate")
	private LocalDate inicioDate;
    
    @Column(name="finDate")
	private LocalDate finDate;
    
    @Column(name="precioTotal")
	private double precioTotal;
	
	@OneToMany(mappedBy="idOrden")
	private List<Producto> productos;
	

	public Orden(LocalDate inicioDate, LocalDate finDate, double precioTotal, List<Producto> productos) {
		super();
		this.inicioDate = inicioDate;
		this.finDate = finDate;
		this.precioTotal = precioTotal;
		this.productos = productos;
	}


	public Orden() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(String idOrden) {
		this.idOrden = idOrden;
	}


	public LocalDate getInicioDate() {
		return inicioDate;
	}


	public void setInicioDate(LocalDate inicioDate) {
		this.inicioDate = inicioDate;
	}


	public LocalDate getFinDate() {
		return finDate;
	}


	public void setFinDate(LocalDate finDate) {
		this.finDate = finDate;
	}


	public double getPrecioTotal() {
		return precioTotal;
	}

	public void addPrecio() {
		
		double precios=0;
		
		for (Producto producto : productos) {
			precios += producto.getPrecioUnit();
		}
		this.precioTotal = precios;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}	
	
}
