package com.javeriana.prosofi.administrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javeriana.prosofi.administrador.model.InvolucradoXProyecto;

@Repository
public interface InvolucradoXProyectoRepository extends JpaRepository<InvolucradoXProyecto, Long> {

}
