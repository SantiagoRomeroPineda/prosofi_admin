package com.javeriana.prosofi.administrador.service;

import java.util.List;
import java.util.Optional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.javeriana.prosofi.administrador.model.Estudiante;
import com.javeriana.prosofi.administrador.repository.EstudianteRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EstudianteService {

	private final EstudianteRepository estudianteRepository;

	public EstudianteService(final EstudianteRepository estudianteRepository) {

		this.estudianteRepository = estudianteRepository;
	}

	public Estudiante addEstudiante(Estudiante estudiante){
		return estudianteRepository.save(estudiante);
	}

	public Estudiante updateEstudiante(Estudiante estudiante, Long estudianteId){
		if(estudianteRepository.findById(estudianteId)!=null){
			return estudianteRepository.save(estudiante);
		}
		log.error("estudainte por id: {} no encontrado",estudianteId);
		throw new EmptyResultDataAccessException("estudiante no encontrada por id " + estudianteId, 1);
	}

	public Optional<Estudiante> findEstudiante(Long estudianteId) {
		return estudianteRepository.findById(estudianteId);
	}

	public List<Estudiante> finaAllEstudiantes(){
		return estudianteRepository.findAll();
	}
}
