package com.GRS.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

/**
 *
 * @author Raul
 */
@Data
@Entity
@Table(name = "proyectos")
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
    CREATE TABLE proyectos (
  id_proyecto INT NOT NULL AUTO_INCREMENT,
  id_servicio INT NOT NULL,
  correo VARCHAR(70) NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  presupuesto FLOAT NOT NULL,
  fecha_inicio DATE NOT NULL,
  fecha_cierre DATE NOT NULL,
  estado VARCHAR(30) NOT NULL,
  ruta_imagen varchar(1024)  
  progreso INT NOT NULL,
  PRIMARY KEY (id_proyecto),
  foreign key fk_id_servicio (id_servicio) references servicios(id_servicio),
  foreign key fk_correo (correo) references usuarios(correo))
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto")
    private Long idProyecto;
    private String nombre;
    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal presupuesto;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_cierre")
    private LocalDate fechaCierre;
    private String estado;
    @Column(name = "ruta_imagen")
    private String rutaImagen;
    private int progreso;
    @ManyToOne
    @JoinColumn(name = "id_servicio", updatable = false)
    private Servicios servicio;
    @ManyToOne
    @JoinColumn(name = "correo", updatable = false)
    private Usuarios usuario;

    public Proyecto(Long idProyecto, String nombre, BigDecimal presupuesto, LocalDate fechaInicio, LocalDate fechaCierre, String estado, String rutaImagen, int progreso, Servicios servicio, Usuarios usuario) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.estado = estado;
        this.rutaImagen = rutaImagen;
        this.progreso = progreso;
        this.servicio = servicio;
        this.usuario = usuario;
    }

    public Proyecto() {
    }

}
