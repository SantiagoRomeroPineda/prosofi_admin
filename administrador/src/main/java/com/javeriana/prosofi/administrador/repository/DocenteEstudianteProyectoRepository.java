package com.javeriana.prosofi.administrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.javeriana.prosofi.administrador.model.DocenteEstudianteProyecto;
import com.javeriana.prosofi.administrador.model.InvolucradoXProyecto;

@Repository
public interface DocenteEstudianteProyectoRepository extends JpaRepository<DocenteEstudianteProyecto, Long> {

	@Query(value = "SELECT * FROM DOCENTE_ESTUDIANTE_PROYECTO where proyecto = ?1", nativeQuery = true)
	List<DocenteEstudianteProyecto> findByProyectoId(Long proyectoId);

	@Query(value = "SELECT * FROM DOCENTE_ESTUDIANTE_PROYECTO where estudiante = ?1", nativeQuery = true)
	List<DocenteEstudianteProyecto> findByEstudianteId(Long estudianteId);

	@Query(value = "SELECT * FROM DOCENTE_ESTUDIANTE_PROYECTO where docente = ?1", nativeQuery = true)
	List<DocenteEstudianteProyecto> findByDocenteId(Long docenteId);
}
