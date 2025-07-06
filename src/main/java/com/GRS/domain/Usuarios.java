package com.GRS.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {

    @Id
    @Column(name = "correo")
    private String correo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "password")
    private String password;

    @Column(name = "rol")
    private String rol;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefonos> telefonos;
}
