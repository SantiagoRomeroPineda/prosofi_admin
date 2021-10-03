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

    public Administrativo(Long idInvolucrado, String documento, String nombre, String telefono, String celular, String correoExterno, Set<InvolucradoXProyecto> proyectos, Date fechaNacimiento, String cargo){
        super(idInvolucrado, documento, nombre, telefono, celular, correoExterno, proyectos, fechaNacimiento);
        this.cargo = cargo;
    }

    public Administrativo() {
    }

}
