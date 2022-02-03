package com.weltio.challenge.mapper;

import org.springframework.stereotype.Component;

import com.weltio.challenge.dto.UsuarioDTO;
import com.weltio.challenge.entity.Usuario;

@Component
public class UsuarioMapper {
	
	public Usuario usuarioDTO2Entity(UsuarioDTO usuarioDto) {
		
		Usuario usuario = new Usuario();
		usuario.setEmail(usuarioDto.getEmail());
		usuario.setNombre(usuarioDto.getNombre());
		usuario.setPassword(usuarioDto.getPassword());
		return usuario;
	}
	
	public UsuarioDTO usuarioEntity2DTO(Usuario usuario) {
		UsuarioDTO usuarioDto = new UsuarioDTO();
		usuarioDto.setEmail(usuario.getEmail());
		usuarioDto.setNombre(usuario.getNombre());
		usuarioDto.setPassword(usuario.getPassword());
		return usuarioDto;
	}
}
