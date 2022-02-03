package com.weltio.challenge.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String email;
	private String nombre;
	private String password;
	private Boolean habilitado;
}
