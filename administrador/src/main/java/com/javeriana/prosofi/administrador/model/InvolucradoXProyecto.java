package com.javeriana.prosofi.administrador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class InvolucradoXProyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_involucrado_por_proyecto")
    private Long idInvolucradoXProyecto;

    @ManyToOne
    @JoinColumn(name = "proyecto")
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "involucrado")
    private Involucrado involucrado;

    @Column(name= "forma_vinculacion", nullable = false, columnDefinition = "varchar(32) default 'CLASE'")
    private FormaVinculacion formaVinculacion;


    public enum FormaVinculacion {
        CLASE, TESIS, PROYECTO_SOCIAL, VOLUNTARIO
    }


}
