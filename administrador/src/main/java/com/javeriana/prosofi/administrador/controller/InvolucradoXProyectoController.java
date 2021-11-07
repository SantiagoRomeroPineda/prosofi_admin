package com.javeriana.prosofi.administrador.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.javeriana.prosofi.administrador.model.Becario;
import com.javeriana.prosofi.administrador.model.Involucrado;
import com.javeriana.prosofi.administrador.model.InvolucradoXProyecto;
import com.javeriana.prosofi.administrador.service.BecarioService;
import com.javeriana.prosofi.administrador.service.InvolucradoXProyectoService;
import com.sun.istack.NotNull;

public class InvolucradoXProyectoController {


	private InvolucradoXProyectoService involucradoXProyectoService;

	public InvolucradoXProyectoController(final InvolucradoXProyectoService involucradoXProyectoService) {

		this.involucradoXProyectoService = involucradoXProyectoService;
	}

	@PostMapping("/addInvolucradoXProyecto")
	public ResponseEntity<InvolucradoXProyecto> add(@NotNull @RequestBody InvolucradoXProyecto involucradoXProyecto) {

		InvolucradoXProyecto newInvolucradoXProyecto = involucradoXProyectoService.addInvolucradoXProyecto(involucradoXProyecto);
		return new ResponseEntity<InvolucradoXProyecto>(newInvolucradoXProyecto, HttpStatus.OK);
	}

	@GetMapping("/findAllInvolucradosXProyecto")
	public ResponseEntity<List<InvolucradoXProyecto>> findAll() {

		List<InvolucradoXProyecto> becarios = involucradoXProyectoService.finaAllInvolucradoXProyectos();
		return new ResponseEntity<List<InvolucradoXProyecto>>(becarios, HttpStatus.OK);
	}

	@GetMapping("/findInvolucradoXProyectoById/{id}")
	public ResponseEntity<InvolucradoXProyecto> findById(@NotNull @PathVariable Long id) {

		InvolucradoXProyecto involucradoXProyecto = involucradoXProyectoService.findInvolucradoXProyecto(id).orElse(null);
		return new ResponseEntity<InvolucradoXProyecto>(involucradoXProyecto, HttpStatus.OK);
	}

	@PutMapping("/updateInvolucradoXProyecto/{id}")
	public ResponseEntity<InvolucradoXProyecto> updateById(@NotNull @PathVariable Long id,
												@NotNull @RequestBody InvolucradoXProyecto involucradoXProyecto) {

		InvolucradoXProyecto newInvolucradoXProyecto = involucradoXProyectoService.updateInvolucradoXProyecto(involucradoXProyecto, id);
		return new ResponseEntity<InvolucradoXProyecto>(newInvolucradoXProyecto, HttpStatus.OK);
	}

}
