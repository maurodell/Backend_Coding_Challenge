package com.weltio.challenge.service;

import com.weltio.challenge.dto.UsuarioDTO;
import com.weltio.challenge.entity.Usuario;

public interface UsuarioService {
	
	Boolean existsByEmail(String email);
	
	UsuarioDTO save(UsuarioDTO usuarioDTO);
	
	Iterable<Usuario> findAll();
	
	UsuarioDTO upload(UsuarioDTO usuarioDTO);
	
	UsuarioDTO findByEmail(String email);
	
	Iterable<Usuario> findAllHabilitado();
}
