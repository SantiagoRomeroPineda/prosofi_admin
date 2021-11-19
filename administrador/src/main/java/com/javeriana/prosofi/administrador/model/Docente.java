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

    @Column(name= "correo_institucional")
    private String correoinstitucional;


    public Docente() {
    }


    public Docente(final Long idInvolucrado, final String documento, final String nombre, final String telefono, final String celular,
                   final String correoExterno,
                   final Set<InvolucradoXProyecto> proyectos, final Date fechaNacimiento, final String facultad,
                   final Set<DocenteEstudianteProyecto> estudianteProyecto, final String correoinstitucional) {

        super(idInvolucrado, documento, nombre, telefono, celular, correoExterno, proyectos, fechaNacimiento);
        this.facultad = facultad;
        this.estudianteProyecto = estudianteProyecto;
        this.correoinstitucional = correoinstitucional;
    }
}
