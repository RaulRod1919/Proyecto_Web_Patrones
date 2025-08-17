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
@Table(name="tipos_acabados")
public class Acabado {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_acabado")
    private Long idAcabado;
    private String nombre;
    @ManyToOne
    @JoinColumn(name="id_empresa", updatable=false)
    private Empresa empresa;

    public Acabado(String nombre, Empresa empresa) {
        this.nombre = nombre;
        this.empresa = empresa;
    }

    public Acabado() {
    }
    
}
