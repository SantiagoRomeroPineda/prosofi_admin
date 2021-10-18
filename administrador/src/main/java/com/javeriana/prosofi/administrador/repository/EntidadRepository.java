package com.javeriana.prosofi.administrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javeriana.prosofi.administrador.model.Entidad;

public interface EntidadRepository extends JpaRepository<Entidad, Long> {

}
