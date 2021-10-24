package com.javeriana.prosofi.administrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.javeriana.prosofi.administrador.model.ResponsableEntidad;
import com.javeriana.prosofi.administrador.repository.ResponsableEntidadRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ResponsableEntidadService {

	private final ResponsableEntidadRepository responsableEntidadRepository;

	public ResponsableEntidadService(final ResponsableEntidadRepository responsableEntidadRepository) {
		this.responsableEntidadRepository = responsableEntidadRepository;
	}

	public ResponsableEntidad addResponsableEntidad(ResponsableEntidad responsableEntidad){
		return responsableEntidadRepository.save(responsableEntidad);
	}

	public ResponsableEntidad updateResponsableEntidad(ResponsableEntidad responsableEntidad, Long responableId){
		if(responsableEntidadRepository.findById(responableId)!=null){
			return responsableEntidadRepository.save(responsableEntidad);
		}
		log.error("User by id {} not found",responableId);
		throw new EmptyResultDataAccessException("User not found.  Id: " + responableId, 1);
	}

	public Optional<ResponsableEntidad> findResponsableEntidad(Long responableId) {
		return responsableEntidadRepository.findById(responableId);
	}

	public List<ResponsableEntidad> finaAllResponsables(){
		return responsableEntidadRepository.findAll();
	}

	}
