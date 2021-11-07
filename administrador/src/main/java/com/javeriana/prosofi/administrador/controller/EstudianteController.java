package com.javeriana.prosofi.administrador.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javeriana.prosofi.administrador.model.Estudiante;
import com.javeriana.prosofi.administrador.service.EstudianteService;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/involucrado/estudiante")
public class EstudianteController {

	private EstudianteService estudianteService;

	public EstudianteController(final EstudianteService estudianteService) {

		this.estudianteService = estudianteService;
	}

	@PostMapping("/addEstudiante")
	public ResponseEntity<Estudiante> add(@NotNull @RequestBody Estudiante estudiante) {

		Estudiante newEstudiante = estudianteService.addEstudiante(estudiante);
		return new ResponseEntity<Estudiante>(newEstudiante, HttpStatus.OK);
	}

	@GetMapping("/findAllEstudiantes")
	public ResponseEntity<List<Estudiante>> findAll() {

		List<Estudiante> estudiantes = estudianteService.finaAllEstudiantes();
		return new ResponseEntity<List<Estudiante>>(estudiantes, HttpStatus.OK);
	}

	@GetMapping("/findEstudianteById/{id}")
	public ResponseEntity<Estudiante> findById(@NotNull @PathVariable Long id) {

		Estudiante estudiante = estudianteService.findEstudiante(id).orElse(null);
		return new ResponseEntity<Estudiante>(estudiante, HttpStatus.OK);
	}

	@PutMapping("/updateEstudiante/{id}")
	public ResponseEntity<Estudiante> updateById(@NotNull @PathVariable Long id,
													 @NotNull @RequestBody Estudiante estudiante) {

		Estudiante newEstudiante = estudianteService.updateEstudiante(estudiante, id);
		return new ResponseEntity<Estudiante>(newEstudiante, HttpStatus.OK);
	}
}
