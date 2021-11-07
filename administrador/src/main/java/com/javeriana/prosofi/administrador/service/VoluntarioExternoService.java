package com.javeriana.prosofi.administrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.javeriana.prosofi.administrador.model.VoluntarioExterno;
import com.javeriana.prosofi.administrador.repository.VoluntarioExternoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VoluntarioExternoService {

	private final VoluntarioExternoRepository voluntarioExternoRepository;

	public VoluntarioExternoService(final VoluntarioExternoRepository voluntarioExternoRepository) {

		this.voluntarioExternoRepository = voluntarioExternoRepository;
	}

	public VoluntarioExterno addVoluntarioExterno(VoluntarioExterno voluntarioExterno){
		return voluntarioExternoRepository.save(voluntarioExterno);
	}

	public VoluntarioExterno updateVoluntarioExterno(VoluntarioExterno voluntarioExterno, Long voluntarioExternoId){
		if(voluntarioExternoRepository.findById(voluntarioExternoId)!=null){
			return voluntarioExternoRepository.save(voluntarioExterno);
		}
		log.error("voluntarioExterno por id: {} no encontrado",voluntarioExternoId);
		throw new EmptyResultDataAccessException("voluntarioExterno no encontrado por id " + voluntarioExternoId, 1);
	}

	public Optional<VoluntarioExterno> findVoluntarioExterno(Long voluntarioExternoId) {
		return voluntarioExternoRepository.findById(voluntarioExternoId);
	}

	public List<VoluntarioExterno> finaAllVoluntarioExterno(){
		return voluntarioExternoRepository.findAll();
	}
}
