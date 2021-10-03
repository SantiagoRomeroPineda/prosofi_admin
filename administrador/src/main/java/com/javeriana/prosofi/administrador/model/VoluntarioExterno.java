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
public class VoluntarioExterno extends Involucrado {
    @Column(name= "organizacion")
    private String organizacion;

    public VoluntarioExterno(Long idInvolucrado, String documento, String nombre, String telefono, String celular, String correoExterno, Set<InvolucradoXProyecto> proyectos, String organizacion, Date fechaNacimiento) {
        super(idInvolucrado, documento, nombre, telefono, celular, correoExterno, proyectos, fechaNacimiento);
        this.organizacion = organizacion;
    }

    public VoluntarioExterno() {
    }
}
