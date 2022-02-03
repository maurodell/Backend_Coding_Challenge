package com.weltio.challenge.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weltio.challenge.dto.UsuarioDTO;
import com.weltio.challenge.entity.Usuario;
import com.weltio.challenge.mapper.UsuarioMapper;
import com.weltio.challenge.repository.UsuarioRepository;
import com.weltio.challenge.service.UsuarioService;

import net.bytebuddy.asm.Advice.OffsetMapping.Target.ForArray.ReadOnly;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	UsuarioMapper usuarioMapper;
	
	@Override
	@Transactional(readOnly = true)
	public Boolean existsByEmail(String email) {
		return usuarioRepository.existsByEmail(email);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public UsuarioDTO save(UsuarioDTO usuarioDTO) {
		Usuario user = usuarioMapper.usuarioDTO2Entity(usuarioDTO);
		Usuario userSave = usuarioRepository.save(user);
		UsuarioDTO result = usuarioMapper.usuarioEntity2DTO(userSave);
		return result;
	}

	@Override
	public UsuarioDTO upload(UsuarioDTO usuarioDTO) {
		Usuario user = usuarioMapper.usuarioDTO2Entity(usuarioDTO);
		Usuario userSave = usuarioRepository.save(user);
		UsuarioDTO result = usuarioMapper.usuarioEntity2DTO(userSave);
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public UsuarioDTO findByEmail(String email) {
		UsuarioDTO result = usuarioMapper.usuarioEntity2DTO(usuarioRepository.findByEmail(email));
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuario> findAllHabilitado() {
		return usuarioRepository.listAllHabilitado();
	}

}
