package com.weltio.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.weltio.challenge.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	
	public Boolean existsByEmail(String email);
	
	@Query("select u from Usuario u where u.email=?1")
	public Usuario findByEmail(String email);
	
	@Query("select u from Usuario u where u.nombre=?1")
	public Usuario findByNombre(String nombre);
	
	@Query("select u from Usuario u where u.habilitado = true")
	public List<Usuario> listAllHabilitado();
	
}
