package com.javeriana.prosofi.administrador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Administrativo extends Involucrado {

    @Column(name= "cargo")
    private String cargo;

    @Column(name= "correo_institucional")
    private String correoinstitucional;

    public Administrativo(final Long idInvolucrado, final String documento, final String nombre, final String telefono,
                          final String celular, final String correoExterno,
                          final Set<InvolucradoXProyecto> proyectos, final Date fechaNacimiento, final String cargo,
                          final String correoinstitucional) {

        super(idInvolucrado, documento, nombre, telefono, celular, correoExterno, proyectos, fechaNacimiento);
        this.cargo = cargo;
        this.correoinstitucional = correoinstitucional;
    }

    public Administrativo() {
    }

}
