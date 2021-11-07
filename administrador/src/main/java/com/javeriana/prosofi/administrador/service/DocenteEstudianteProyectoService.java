package com.javeriana.prosofi.administrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.javeriana.prosofi.administrador.model.DocenteEstudianteProyecto;
import com.javeriana.prosofi.administrador.repository.DocenteEstudianteProyectoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DocenteEstudianteProyectoService {

	private final DocenteEstudianteProyectoRepository repository;

	public DocenteEstudianteProyectoService(final DocenteEstudianteProyectoRepository repository) {

		this.repository = repository;
	}

	public DocenteEstudianteProyecto addDocenteEstudianteProyecto(DocenteEstudianteProyecto docenteEstudianteProyecto){
		return repository.save(docenteEstudianteProyecto);
	}

	public DocenteEstudianteProyecto updateDocenteEstudianteProyecto(DocenteEstudianteProyecto docenteEstudianteProyecto, Long docenteEstudianteProyectoId){
		if(repository.findById(docenteEstudianteProyectoId)!=null){
			return repository.save(docenteEstudianteProyecto);
		}
		log.error("docenteEstudianteProyecto por id: {} no encontrado",docenteEstudianteProyectoId);
		throw new EmptyResultDataAccessException("docenteEstudianteProyecto no encontrado por id " + docenteEstudianteProyectoId, 1);
	}

	public Optional<DocenteEstudianteProyecto> findDocenteEstudianteProyecto(Long docenteEstudianteProyectoId) {
		return repository.findById(docenteEstudianteProyectoId);
	}

	public List<DocenteEstudianteProyecto> finaAllDocenteEstudianteProyecto(){
		return repository.findAll();
	}
}
