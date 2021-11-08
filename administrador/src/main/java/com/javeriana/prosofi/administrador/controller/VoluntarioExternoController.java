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
import com.javeriana.prosofi.administrador.model.VoluntarioExterno;
import com.javeriana.prosofi.administrador.service.VoluntarioExternoService;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/involucrado/voluntarioExterno")
public class VoluntarioExternoController {

	private VoluntarioExternoService voluntarioExternoService;

	public VoluntarioExternoController(final VoluntarioExternoService voluntarioExternoService) {

		this.voluntarioExternoService = voluntarioExternoService;
	}

	@PostMapping("/addVoluntarioExterno")
	public ResponseEntity<VoluntarioExterno> add(@NotNull @RequestBody VoluntarioExterno voluntarioExterno) {

		VoluntarioExterno newVoluntarioExterno = voluntarioExternoService.addVoluntarioExterno(voluntarioExterno);
		return new ResponseEntity<VoluntarioExterno>(newVoluntarioExterno, HttpStatus.OK);
	}

	@GetMapping("/findAllVoluntariosExternos")
	public ResponseEntity<List<VoluntarioExterno>> findAll() {

		List<VoluntarioExterno> voluntariosExternos = voluntarioExternoService.finaAllVoluntarioExterno();
		return new ResponseEntity<List<VoluntarioExterno>>(voluntariosExternos, HttpStatus.OK);
	}

	@GetMapping("/findVoluntarioExternoById/{id}")
	public ResponseEntity<VoluntarioExterno> findById(@NotNull @PathVariable Long id) {

		VoluntarioExterno voluntarioExterno = voluntarioExternoService.findVoluntarioExterno(id).orElse(null);
		return new ResponseEntity<VoluntarioExterno>(voluntarioExterno, HttpStatus.OK);
	}

	@PutMapping("/updateVoluntarioExterno/{id}")
	public ResponseEntity<VoluntarioExterno> updatateById(@NotNull @PathVariable Long id,
												   @NotNull @RequestBody VoluntarioExterno voluntarioExterno) {

		VoluntarioExterno newVoluntarioExterno = voluntarioExternoService.updateVoluntarioExterno(voluntarioExterno, id);
		return new ResponseEntity<VoluntarioExterno>(newVoluntarioExterno, HttpStatus.OK);
	}

}
