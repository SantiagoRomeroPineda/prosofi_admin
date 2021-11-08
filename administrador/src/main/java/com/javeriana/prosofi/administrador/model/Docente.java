package com.javeriana.prosofi.administrador.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
public class Docente extends Involucrado {

    @Column(name= "facultad")
    private String facultad;

    @OneToMany(mappedBy = "docente")
    @JsonIgnore
    private Set<DocenteEstudianteProyecto> estudianteProyecto;

    public Docente() {
    }

    public Docente(Long idInvolucrado, String documento, String nombre, String telefono, String celular, String correoExterno, Set<InvolucradoXProyecto> proyectos, Date fechaNacimiento, String facultad, Set<DocenteEstudianteProyecto> estudianteProyecto) {
        super(idInvolucrado, documento, nombre, telefono, celular, correoExterno, proyectos, fechaNacimiento);
        this.facultad = facultad;
        this.estudianteProyecto = estudianteProyecto;
    }
}
