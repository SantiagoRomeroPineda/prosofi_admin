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

    @Column(name= "carrera")
    private String carrera;

    @OneToMany(mappedBy = "estudiante")
    @JsonIgnore
    private Set<DocenteEstudianteProyecto> proyectoDocente;

    public Estudiante() {
    }

    public Estudiante(Long idInvolucrado, String documento, String nombre, String telefono, String celular, String correoExterno, Set<InvolucradoXProyecto> proyectos, Date fechaNacimiento, String facultad, String carrera, Set<DocenteEstudianteProyecto> proyectoDocente) {
        super(idInvolucrado, documento, nombre, telefono, celular, correoExterno, proyectos, fechaNacimiento);
        this.facultad = facultad;
        this.carrera = carrera;
        this.proyectoDocente = proyectoDocente;
    }
}
