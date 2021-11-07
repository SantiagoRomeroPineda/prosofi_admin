package com.javeriana.prosofi.administrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.javeriana.prosofi.administrador.model.Administrativo;
import com.javeriana.prosofi.administrador.repository.AdministrativoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdministrativoService {

	private final AdministrativoRepository administrativoRepository;

	public AdministrativoService(final AdministrativoRepository administrativoRepository) {

		this.administrativoRepository = administrativoRepository;
	}

	public Administrativo addAdministrativo(Administrativo becario){
		return administrativoRepository.save(becario);
	}

	public Administrativo updateAdministrativo(Administrativo administrativo, Long administrativoId){
		if(administrativoRepository.findById(administrativoId)!=null){
			return administrativoRepository.save(administrativo);
		}
		log.error("becario por id: {} no encontrado",administrativoId);
		throw new EmptyResultDataAccessException("Entidad no encontrada por id " + administrativoId, 1);
	}

	public Optional<Administrativo> findAdministrativo(Long administrativoId) {
		return administrativoRepository.findById(administrativoId);
	}

	public List<Administrativo> finaAllAdministrativos(){
		return administrativoRepository.findAll();
	}
}
