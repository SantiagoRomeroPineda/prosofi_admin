package com.javeriana.prosofi.administrador.model;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "entidad")
public class Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_entidad")
    private Long idEntidad;

    @Column(name= "nombre")
    private String nombre;

    @Column(name= "celular")
    private String celular;

    @Column(name= "direccion")
    private String direccion;

    @Column(name= "descripcion")
    private String descripcion;

    @Column(name= "fecha_vinculacion")
    @CreationTimestamp
    private Date fechaVinvulacion;

    @OneToMany(mappedBy="entidad")
    private List<ResponsableEntidad> responsableEntidad = new ArrayList<>();

    @OneToMany(mappedBy="entidad")
    private List<Proyecto> proyectos = new ArrayList<>();

    public Entidad() {}

}
