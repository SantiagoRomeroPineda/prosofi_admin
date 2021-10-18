package com.javeriana.prosofi.administrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javeriana.prosofi.administrador.model.Administrativo;

@Repository
public interface AdministrativoRepository extends JpaRepository<Administrativo, Long> {

}
