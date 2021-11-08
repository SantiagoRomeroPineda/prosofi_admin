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
import com.javeriana.prosofi.administrador.model.Becario;
import com.javeriana.prosofi.administrador.model.Involucrado;
import com.javeriana.prosofi.administrador.service.BecarioService;
import com.javeriana.prosofi.administrador.service.InvolucradoXProyectoService;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/involucrado/becario")
public class BecarioController {

	private  BecarioService becarioService;

	public BecarioController(final BecarioService becarioService) {

		this.becarioService = becarioService;
	}

	@PostMapping("/addBecario")
	public ResponseEntity<Becario> add(@NotNull @RequestBody Becario becario) {

		Becario newBecario = becarioService.addBecario(becario);
		return new ResponseEntity<Becario>(newBecario, HttpStatus.OK);
	}

	@GetMapping("/findAllBecarios")
	public ResponseEntity<List<Involucrado>> findAll() {

		List<Involucrado> becarios = becarioService.finaAllBecarios();
		return new ResponseEntity<List<Involucrado>>(becarios, HttpStatus.OK);
	}

	@GetMapping("/findBecarioById/{id}")
	public ResponseEntity<Involucrado> findById(@NotNull @PathVariable Long id) {

		Involucrado becario = becarioService.findBecario(id).orElse(null);
		return new ResponseEntity<Involucrado>(becario, HttpStatus.OK);
	}

	@PutMapping("/updateBecario/{id}")
	public ResponseEntity<Becario> updatateById(@NotNull @PathVariable Long id,
												@NotNull @RequestBody Becario becario) {

		Becario newBecario = becarioService.updateBecario(becario, id);
		return new ResponseEntity<Becario>(newBecario, HttpStatus.OK);
	}

}
