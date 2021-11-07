package com.javeriana.prosofi.administrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.javeriana.prosofi.administrador.model.Docente;
import com.javeriana.prosofi.administrador.repository.DocenteRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DocenteService {

	private final DocenteRepository docenteRepository;

	public DocenteService(final DocenteRepository docenteRepository) {

		this.docenteRepository = docenteRepository;
	}

	public Docente addDocente(Docente docente){
		return docenteRepository.save(docente);
	}

	public Docente updateDocente(Docente docente, Long docenteId){
		if(docenteRepository.findById(docenteId)!=null){
			return docenteRepository.save(docente);
		}
		log.error("docente por id: {} no encontrado",docenteId);
		throw new EmptyResultDataAccessException("docente no encontrada por id " + docenteId, 1);
	}

	public Optional<Docente> findDocente(Long docenteId) {
		return docenteRepository.findById(docenteId);
	}

	public List<Docente> finaAllDocentes(){
		return docenteRepository.findAll();
	}
}
