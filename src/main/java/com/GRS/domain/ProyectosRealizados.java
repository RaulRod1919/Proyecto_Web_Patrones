/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GRS.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

/**
 *
 * @author Raul
 */
@Data
@Entity
@Table(name="proyectos_realizados")
public class ProyectosRealizados {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_proyecto_realizado")
    private Long idProyectoRealizado;
    @Column(name="id_empresa")
    private Long idEmpresa;
    private String nombre;
    private String descripcion;
    @Column(name="ruta_imagen")
    private String rutaImagen;

    public ProyectosRealizados(Long idEmpresa, String nombre, String descripcion, String rutaImagen) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
    }

    public ProyectosRealizados() {
    }
    
    
}
