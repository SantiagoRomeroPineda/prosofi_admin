package com.javeriana.prosofi.administrador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "becario")
public class Becario extends Involucrado{

    @Column(name= "correo_institucional")
    private String correoinstitucional;

    public Becario(final Long idInvolucrado, final String documento, final String nombre, final String telefono, final String celular,
                   final String correoExterno,
                   final Set<InvolucradoXProyecto> proyectos, final Date fechaNacimiento, final String correoinstitucional) {

        super(idInvolucrado, documento, nombre, telefono, celular, correoExterno, proyectos, fechaNacimiento);
        this.correoinstitucional = correoinstitucional;
    }

    public Becario() {
    }
}
