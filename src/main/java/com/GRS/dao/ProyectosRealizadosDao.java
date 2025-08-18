/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.GRS.dao;

import com.GRS.domain.ProyectosRealizados;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Raul
 */
public interface ProyectosRealizadosDao extends JpaRepository<ProyectosRealizados, Long> {
    
}
