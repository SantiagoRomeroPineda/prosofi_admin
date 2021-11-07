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
import com.javeriana.prosofi.administrador.model.DocenteEstudianteProyecto;
import com.javeriana.prosofi.administrador.model.Involucrado;
import com.javeriana.prosofi.administrador.service.DocenteEstudianteProyectoService;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/tutores")
public class DocenteEstudianteProyectoController {


	private DocenteEstudianteProyectoService service;

	public DocenteEstudianteProyectoController(final DocenteEstudianteProyectoService service) {

		this.service = service;
	}

	@PostMapping("/addDocenteEstudianteProyecto")
	public ResponseEntity<DocenteEstudianteProyecto> add(@NotNull @RequestBody DocenteEstudianteProyecto docenteEstudianteProyecto) {

		DocenteEstudianteProyecto newDocenteEstudianteProyecto = service.addDocenteEstudianteProyecto(docenteEstudianteProyecto);
		return new ResponseEntity<DocenteEstudianteProyecto>(newDocenteEstudianteProyecto, HttpStatus.OK);
	}

	@GetMapping("/findAllDocenteEstudianteProyecto")
	public ResponseEntity<List<DocenteEstudianteProyecto>> findAll() {

		List<DocenteEstudianteProyecto> docenteEstudianteProyecto = service.finaAllDocenteEstudianteProyecto();
		return new ResponseEntity<List<DocenteEstudianteProyecto>>(docenteEstudianteProyecto, HttpStatus.OK);
	}

	@GetMapping("/findEstudiateDocenteById/{id}")
	public ResponseEntity<DocenteEstudianteProyecto> findById(@NotNull @PathVariable Long id) {

		DocenteEstudianteProyecto docenteEstudianteProyecto = service.findDocenteEstudianteProyecto(id).orElse(null);
		return new ResponseEntity<DocenteEstudianteProyecto>(docenteEstudianteProyecto, HttpStatus.OK);
	}

	@PutMapping("/updateEstudiateDocente/{id}")
	public ResponseEntity<DocenteEstudianteProyecto> updatateById(@NotNull @PathVariable Long id,
												@NotNull @RequestBody DocenteEstudianteProyecto docenteEstudianteProyecto) {

		DocenteEstudianteProyecto newDocenteEstudianteProyecto = service.updateDocenteEstudianteProyecto(docenteEstudianteProyecto, id);
		return new ResponseEntity<DocenteEstudianteProyecto>(newDocenteEstudianteProyecto, HttpStatus.OK);
	}
}
