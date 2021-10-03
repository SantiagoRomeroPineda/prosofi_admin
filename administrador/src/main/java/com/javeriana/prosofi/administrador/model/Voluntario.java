package com.javeriana.prosofi.administrador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "voluntario")
public class Voluntario extends Involucrado {
    public Voluntario(Long idInvolucrado, String documento, String nombre, String telefono, String celular, String correoExterno, Set<InvolucradoXProyecto> proyectos, Date fechaNacimiento){
        super(idInvolucrado, documento, nombre, telefono, celular, correoExterno, proyectos, fechaNacimiento);
    }

    public Voluntario() {
    }
}
