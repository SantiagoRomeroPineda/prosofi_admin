package com.javeriana.prosofi.administrador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "involucrado")
public class Involucrado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_involucrado")
    private Long idInvolucrado;

    @Column(name= "documento", nullable = false)
    private String documento;

    @Column(name= "nombre")
    private String nombre;

    @Column(name= "telefono")
    private String telefono;

    @Column(name= "celular")
    private String celular;

    @Column(name= "correo_externo")
    private String correoExterno;

    @OneToMany(mappedBy = "involucrado")
    private Set<InvolucradoXProyecto> proyectos;
}
