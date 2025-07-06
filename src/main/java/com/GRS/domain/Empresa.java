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
@Table(name="empresa")
public class Empresa implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_empresa")
    private Long idEmpresa;
    private String descripcion;
    @Column(name="tipos_construcciones")
    private String tipoConstrucciones;
    private String nombre;
    
    public Empresa(String descripcion, String tipoConstrucciones) {
        this.descripcion = descripcion;
        this.tipoConstrucciones = tipoConstrucciones;
    }

    public Empresa() {
    }
    
}
