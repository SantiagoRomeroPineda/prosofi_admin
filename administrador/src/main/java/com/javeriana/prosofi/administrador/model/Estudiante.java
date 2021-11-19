package com.javeriana.prosofi.administrador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@Table(name = "Estudiante")
public class Estudiante extends Involucrado{

    @Column(name= "facultad")
    private String facultad;

    @Column(name= "programa")
    private String programa;

    @OneToMany(mappedBy = "estudiante")
    @JsonIgnore
    private Set<DocenteEstudianteProyecto> proyectoDocente;

    @Column(name= "correo_institucional")
    private String correoinstitucional;

    public Estudiante(final Long idInvolucrado, final String documento, final String nombre, final String telefono, final String celular,
                      final String correoExterno,
                      final Set<InvolucradoXProyecto> proyectos, final Date fechaNacimiento, final String facultad, final String programa,
                      final Set<DocenteEstudianteProyecto> proyectoDocente, final String correoinstitucional) {

        super(idInvolucrado, documento, nombre, telefono, celular, correoExterno, proyectos, fechaNacimiento);
        this.facultad = facultad;
        this.programa = programa;
        this.proyectoDocente = proyectoDocente;
        this.correoinstitucional = correoinstitucional;
    }

    public Estudiante() {
    }

}
