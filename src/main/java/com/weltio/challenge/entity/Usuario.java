package com.weltio.challenge.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
	private String id;
    
	@Column(name="email", unique = true)
	@NotEmpty(message = "debe ingresar email")
	@Email(message = "ingrese el formato correcto")
	private String email;
	
	@Column(name = "nombre", unique = true, length = 20)
	@NotEmpty(message = "debe ingresar nombre")
	private String nombre;
	
	@Column(name="password", length = 65)
	@NotEmpty(message = "debe ingresar password")
	private String password;
	
	private Boolean habilitado = true;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id"),
	inverseJoinColumns = @JoinColumn(name = "role_id"), 
	uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "role_id"})})
	private List<Rol> roles;
	
	

	public Usuario(
			@NotEmpty(message = "debe ingresar email") @Email(message = "ingrese el formato correcto") String email,
			@NotEmpty(message = "debe ingresar nombre") String nombre,
			@NotEmpty(message = "debe ingresar password") String password, List<Rol> roles) {
		this.email = email;
		this.nombre = nombre;
		this.password = password;
		this.roles = roles;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	
}
