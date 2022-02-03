package com.weltio.challenge.serviceAuth;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weltio.challenge.entity.Usuario;
import com.weltio.challenge.repository.UsuarioRepository;
import com.weltio.challenge.serviceImpl.UsuarioServiceImpl;

@Service
public class UsuarioServiceAuth implements UserDetailsService {
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		Usuario usuario = this.usuarioRepository.findByNombre(name);
		
		if(usuario == null) {
			log.error("error, el usuario no existe");
			throw new UsernameNotFoundException("error, el usuario no existe");
		}
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority -> log.info("Role: "+authority.getAuthority()))
				.collect(Collectors.toList());
		return new User(usuario.getNombre(), usuario.getPassword(), usuario.getHabilitado(), true, true, true, authorities);
	}

}
