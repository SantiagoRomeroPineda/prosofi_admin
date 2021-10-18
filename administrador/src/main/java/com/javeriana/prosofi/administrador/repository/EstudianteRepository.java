package com.javeriana.prosofi.administrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javeriana.prosofi.administrador.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}
