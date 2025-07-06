package com.GRS.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "telefonos")
public class Telefonos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefono")
    private Long idTelefono;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "correo", referencedColumnName = "correo")
    private Usuarios usuario;
}
