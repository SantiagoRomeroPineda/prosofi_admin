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
import com.javeriana.prosofi.administrador.model.Voluntario;
import com.javeriana.prosofi.administrador.service.VoluntarioService;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/involucrado/voluntario")
public class VoluntarioController {

	private VoluntarioService voluntarioService;

	public VoluntarioController(final VoluntarioService voluntarioService) {

		this.voluntarioService = voluntarioService;
	}

	@PostMapping("/addVoluntario")
	public ResponseEntity<Voluntario> add(@NotNull @RequestBody Voluntario voluntario) {

		Voluntario newVoluntario = voluntarioService.addVoluntario(voluntario);
		return new ResponseEntity<Voluntario>(newVoluntario, HttpStatus.OK);
	}

	@GetMapping("/findAllVoluntarios")
	public ResponseEntity<List<Voluntario>> findAll() {

		List<Voluntario> voluntarios = voluntarioService.finaAllVoluntario();
		return new ResponseEntity<List<Voluntario>>(voluntarios, HttpStatus.OK);
	}

	@GetMapping("/findVoluntarioById/{id}")
	public ResponseEntity<Voluntario> findById(@NotNull @PathVariable Long id) {

		Voluntario voluntario = voluntarioService.findVoluntario(id).orElse(null);
		return new ResponseEntity<Voluntario>(voluntario, HttpStatus.OK);
	}

	@PutMapping("/updateVoluntario/{id}")
	public ResponseEntity<Voluntario> updatateById(@NotNull @PathVariable Long id,
												@NotNull @RequestBody Voluntario voluntario) {

		Voluntario newVoluntario = voluntarioService.updateVoluntario(voluntario, id);
		return new ResponseEntity<Voluntario>(newVoluntario, HttpStatus.OK);
	}

}
