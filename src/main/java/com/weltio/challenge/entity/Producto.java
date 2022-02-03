package com.weltio.challenge.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="producto")
public class Producto implements Serializable{

	private static final long serialVersionUID = 3070293508961026195L;
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
	private String id;
	
	@Column(name="nombreProducto")
	private String nombreProducto;
	
	@Column(name="precioUnit")
	private double precioUnit;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idOrden")
	private Orden idOrden;
	

	
	
	public Producto(String nombreProducto, double precioUnit, Integer cantidad, Orden idOrden) {
		super();
		this.nombreProducto = nombreProducto;
		this.precioUnit = precioUnit;
		this.cantidad = cantidad;
		this.idOrden = idOrden;
	}

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orden getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(Orden idOrden) {
		this.idOrden = idOrden;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getPrecioUnit() {
		return precioUnit;
	}

	public void setPrecioUnit(double precioUnit) {
		this.precioUnit = precioUnit;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	
	
	
}
