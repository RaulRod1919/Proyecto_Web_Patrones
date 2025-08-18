/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GRS.servicesImpl;

import com.GRS.dao.ProyectosRealizadosDao;
import com.GRS.domain.ProyectosRealizados;
import com.GRS.services.ProyectosRealizadosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Raul
 */
@Service
public class ProyectosRealizadosServiceImpl implements ProyectosRealizadosService{

    @Autowired
    private ProyectosRealizadosDao proyectosRealizadosDao;
    
    @Override
    @Transactional
    public void save(ProyectosRealizados proyecto) {
        proyectosRealizadosDao.save(proyecto);
    }

    @Override
    @Transactional
    public void delete(ProyectosRealizados proyecto) {
        proyectosRealizadosDao.delete(proyecto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProyectosRealizados> getProyectos() {
        return proyectosRealizadosDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ProyectosRealizados getProyecto(Long idProyecto) {
        return proyectosRealizadosDao.findById(idProyecto).orElse(null);
    }
    
    
}
