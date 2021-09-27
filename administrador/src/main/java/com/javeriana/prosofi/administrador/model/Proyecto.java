package com.javeriana.prosofi.administrador.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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
    private Set<InvolucradoXProyecto> involucrados;
}
