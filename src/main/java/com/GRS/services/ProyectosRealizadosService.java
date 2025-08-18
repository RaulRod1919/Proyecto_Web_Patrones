/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.GRS.services;

import com.GRS.domain.ProyectosRealizados;
import java.util.List;

/**
 *
 * @author Raul
 */
public interface ProyectosRealizadosService {
    
    public void save(ProyectosRealizados proyecto);
    
    public void delete(ProyectosRealizados proyecto);
    
    public List<ProyectosRealizados> getProyectos();
    
    public ProyectosRealizados getProyecto(Long idProyecto);
    
}
