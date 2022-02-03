package com.weltio.challenge;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.weltio.challenge.entity.Rol;
import com.weltio.challenge.entity.Usuario;
import com.weltio.challenge.repository.RolRepository;
import com.weltio.challenge.repository.UsuarioRepository;

@SpringBootApplication
public class ChallengeApplication implements CommandLineRunner{
	
	/***
	 * Para acceder a la documentacion: http://localhost:8080/swagger-ui/index.html
	 * para acceder a las apis: /v3/api-docs/
	 * 
	 * @author mdo
	 */
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}
	
	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		/***
		 * Se crean los rolesy usuarios
		 * @author mdo
		 */
		if(rolRepository.count() == 0) {
			Rol role_user = new Rol("ROLE_USER");
			rolRepository.save(role_user);
		
			Rol role_admin = new Rol("ROLE_ADMIN");
			rolRepository.save(role_admin);
		}
		
		if(usuarioRepository.count()==0) {
			Usuario usuario1 = new Usuario();
			usuario1.setEmail("email@gmail.com");
			usuario1.setNombre("Mauro");
			usuario1.setPassword(passwordEncoder.encode("admin"));
			usuarioRepository.save(usuario1);
		}
		
		
		/*
		
		String password = "springboot";
		
		for (int i = 0; i < 3; i++) {
			String passwordBcrypt = passwordEncoder.encode(password);
			System.out.println(passwordBcrypt);
		}
		*/
	}

}
