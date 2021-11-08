package com.javeriana.prosofi.administrador.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@Table(name = "proyecto")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_proyecto")
    private Long idProyecto;

    @Column(name= "descripcion")
    private String descripcion;

    @Column(name= "objetivos")
    private String objetivos;

    @Column(name= "fecha_inicio")
    @CreationTimestamp
    private Date fechaInicio;

    @Column(name= "fecha_fin")
    private Date fechaFin;

    @ManyToOne
    private Entidad entidad;

    @OneToOne
    private Involucrado lider;

    @OneToMany(mappedBy="proyecto")
    @JsonIgnore
    private Set<InvolucradoXProyecto> involucrados;

    @OneToMany(mappedBy = "proyecto")
    @JsonIgnore
    private Set<DocenteEstudianteProyecto> esudianteDocente;

    public Proyecto(Long idProyecto, String descripcion, String objetivos, Date fechaInicio, Date fechaFin, Entidad entidad, Involucrado lider, Set<InvolucradoXProyecto> involucrados, Set<DocenteEstudianteProyecto> esudianteDocente) {
        this.idProyecto = idProyecto;
        this.descripcion = descripcion;
        this.objetivos = objetivos;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.entidad = entidad;
        this.lider = lider;
        this.involucrados = involucrados;
        this.esudianteDocente = esudianteDocente;
    }

    public Proyecto() {
    }
}
