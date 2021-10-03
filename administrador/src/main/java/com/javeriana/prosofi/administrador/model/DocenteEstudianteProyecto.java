package com.javeriana.prosofi.administrador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "docente_estudiante_proyecto")
public class DocenteEstudianteProyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_docente_estudiante_proyecto")
    private Long idDocenteEstudianteProyecto;

    @ManyToOne
    @JoinColumn(name = "estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "docente")
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "proyecto")
    private Proyecto proyecto;

    @Column(name= "periodo_academico", nullable = false)
    private String periodoAcademico;

    public DocenteEstudianteProyecto() {
    }

    public DocenteEstudianteProyecto(Long idDocenteEstudianteProyecto, Estudiante estudiante, Docente docente, Proyecto proyecto, String periodoAcademico) {
        this.idDocenteEstudianteProyecto = idDocenteEstudianteProyecto;
        this.estudiante = estudiante;
        this.docente = docente;
        this.proyecto = proyecto;
        this.periodoAcademico = periodoAcademico;
    }
}
