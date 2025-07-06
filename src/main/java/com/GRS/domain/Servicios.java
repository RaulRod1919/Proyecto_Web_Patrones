package com.GRS.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "servicios")
public class Servicios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Long idServicio;
    @Column(name = "id_empresa")
    private Long idEmpresa;
    private String nombre;
    private String descripcion;

    public Servicios(Long idEmpresa, String nombre, String descripcion) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Servicios() {
    }
    
}
