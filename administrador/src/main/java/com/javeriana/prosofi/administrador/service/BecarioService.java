package com.javeriana.prosofi.administrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.javeriana.prosofi.administrador.model.Becario;
import com.javeriana.prosofi.administrador.model.Involucrado;
import com.javeriana.prosofi.administrador.repository.BecarioRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BecarioService {

	private final BecarioRepository becarioRepository;

	public BecarioService(final BecarioRepository becarioRepository) {

		this.becarioRepository = becarioRepository;
	}

	public Becario addBecario(Becario becario){
		return becarioRepository.save(becario);
	}

	public Becario updateBecario(Becario becario, Long becarioId){
		if(becarioRepository.findById(becarioId)!=null){
			return becarioRepository.save(becario);
		}
		log.error("becario por id: {} no encontrado",becarioId);
		throw new EmptyResultDataAccessException("Entidad no encontrada por id " + becarioId, 1);
	}

	public Optional<Involucrado> findBecario(Long becarioId) {
		return becarioRepository.findById(becarioId);
	}

	public List<Involucrado> finaAllBecarios(){
		return becarioRepository.findAll();
	}
}
