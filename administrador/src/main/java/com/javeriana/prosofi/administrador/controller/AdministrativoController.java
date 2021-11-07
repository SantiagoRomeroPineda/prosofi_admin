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
import com.javeriana.prosofi.administrador.model.Administrativo;
import com.javeriana.prosofi.administrador.service.AdministrativoService;

import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/involucrado/administrativo")
public class AdministrativoController {

	private AdministrativoService administrativoService;

	public AdministrativoController(final AdministrativoService administrativoService) {

		this.administrativoService = administrativoService;
	}

	@PostMapping("/addAdministrativo")
	public ResponseEntity<Administrativo> add(@NotNull @RequestBody Administrativo administrativo) {

		Administrativo newAdministrativo = administrativoService.addAdministrativo(administrativo);
		return new ResponseEntity<Administrativo>(newAdministrativo, HttpStatus.OK);
	}

	@GetMapping("/findAllAdministrativos")
	public ResponseEntity<List<Administrativo>> findAll() {

		List<Administrativo> administrativos = administrativoService.finaAllAdministrativos();
		return new ResponseEntity<List<Administrativo>>(administrativos, HttpStatus.OK);
	}

	@GetMapping("/findAdministrativoById/{id}")
	public ResponseEntity<Administrativo> findById(@NotNull @PathVariable Long id) {

		Administrativo administrativo = administrativoService.findAdministrativo(id).orElse(null);
		return new ResponseEntity<Administrativo>(administrativo, HttpStatus.OK);
	}

	@PutMapping("/updateAdministrativo/{id}")
	public ResponseEntity<Administrativo> updateById(@NotNull @PathVariable Long id,
												@NotNull @RequestBody Administrativo administrativo) {

		Administrativo newBecario = administrativoService.updateAdministrativo(administrativo, id);
		return new ResponseEntity<Administrativo>(newBecario, HttpStatus.OK);
	}
}
