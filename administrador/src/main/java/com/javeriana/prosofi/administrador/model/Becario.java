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
@Table(name = "becario")
public class Becario extends Involucrado{
    public Becario(Long idInvolucrado, String documento, String nombre, String telefono, String celular, String correoExterno, Set<InvolucradoXProyecto> proyectos, String facultad, Date fechaNacimiento){
        super(idInvolucrado, documento, nombre, telefono, celular, correoExterno, proyectos, fechaNacimiento);
    }

    public Becario() {
    }
}
