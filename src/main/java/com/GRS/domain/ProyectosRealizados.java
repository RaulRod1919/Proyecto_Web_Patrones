package com.GRS.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "proyectos")
public class ProyectosRealizados implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto")
    private Long idProyecto;

    @ManyToOne
    @JoinColumn(name = "id_servicio", nullable = false)
    private Servicios servicio;

    @ManyToOne
    @JoinColumn(name = "correo", referencedColumnName = "correo", nullable = false)
    private Usuarios usuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "presupuesto")
    private float presupuesto;

    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fecha_cierre")
    @Temporal(TemporalType.DATE)
    private Date fechaCierre;

    @Column(name = "estado")
    private String estado;

    @Column(name = "progreso")
    private int progreso;

    public ProyectosRealizados() {
    }

    public ProyectosRealizados(Servicios servicio, Usuarios usuario, String nombre, float presupuesto, Date fechaInicio, Date fechaCierre, String estado, int progreso) {
        this.servicio = servicio;
        this.usuario = usuario;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.estado = estado;
        this.progreso = progreso;
    }
}