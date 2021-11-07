package com.javeriana.prosofi.administrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.javeriana.prosofi.administrador.model.Voluntario;
import com.javeriana.prosofi.administrador.repository.VoluntarioRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VoluntarioService {

	private final VoluntarioRepository voluntarioRepository;

	public VoluntarioService(final VoluntarioRepository voluntarioRepository) {

		this.voluntarioRepository = voluntarioRepository;
	}

	public Voluntario addVoluntario(Voluntario voluntario){
		return voluntarioRepository.save(voluntario);
	}

	public Voluntario updateVoluntario(Voluntario voluntario, Long voluntarioId){
		if(voluntarioRepository.findById(voluntarioId)!=null){
			return voluntarioRepository.save(voluntario);
		}
		log.error("Voluntario por id: {} no encontrado",voluntarioId);
		throw new EmptyResultDataAccessException("Voluntario no encontrado por id " + voluntarioId, 1);
	}

	public Optional<Voluntario> findVoluntario(Long voluntarioId) {
		return voluntarioRepository.findById(voluntarioId);
	}

	public List<Voluntario> finaAllVoluntario(){
		return voluntarioRepository.findAll();
	}
}
