package com.javeriana.prosofi.administrador.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "responsable_entidad")
public class ResponsableEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_responsable_entidad")
    private Long idResponsableEntidad;

    @Column(name= "documento", nullable = false)
    private String documento;

    @Column(name= "nombre")
    private String nombre;

    @Column(name= "telefono")
    private String telefono;

    @Column(name= "celular")
    private String celular;

    @Column(name= "correo")
    private String correo;

    @ManyToOne
    private Entidad entidad;

}
