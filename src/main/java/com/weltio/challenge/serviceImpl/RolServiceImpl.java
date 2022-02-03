package com.weltio.challenge.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weltio.challenge.entity.Rol;
import com.weltio.challenge.repository.RolRepository;
import com.weltio.challenge.service.RolService;

@Service
public class RolServiceImpl implements RolService{
	
	@Autowired
	RolRepository rolRepository;

	@Override
	public Rol save(Rol rol) {
		return rolRepository.save(rol);
	}
	
}
