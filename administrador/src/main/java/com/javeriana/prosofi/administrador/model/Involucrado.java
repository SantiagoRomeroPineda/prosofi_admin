package com.javeriana.prosofi.administrador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
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

    @Column(name= "fecha_nacimiento")
    private Date fechaNacimiento;


    @OneToMany(mappedBy = "involucrado")
    private Set<InvolucradoXProyecto> proyectos;

    public Involucrado() {
    }

    public Involucrado(Long idInvolucrado, String documento, String nombre, String telefono, String celular, String correoExterno, Set<InvolucradoXProyecto> proyectos, Date fechaNacimiento) {
        this.idInvolucrado = idInvolucrado;
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.celular = celular;
        this.correoExterno = correoExterno;
        this.proyectos = proyectos;
        this.fechaNacimiento = fechaNacimiento;
    }
}
