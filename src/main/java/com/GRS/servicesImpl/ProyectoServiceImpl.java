/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GRS.servicesImpl;

import com.GRS.dao.ProyectoDao;
import com.GRS.domain.Proyecto;
import com.GRS.services.ProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Raul
 */
@Service
public class ProyectoServiceImpl implements ProyectoService{
    
    @Autowired
    private ProyectoDao proyectoDao;

    @Override
    @Transactional
    public void save(Proyecto proyecto) {
        proyectoDao.save(proyecto);
    }

    @Override
    @Transactional
    public void delete(Proyecto proyecto) {
        proyectoDao.delete(proyecto);
    }

    @Override
    @Transactional(readOnly = true)
    public Proyecto getProyecto(Proyecto proyecto) {
        return proyectoDao.findById(proyecto.getIdProyecto()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Proyecto> getProyectos() {
        List lista = proyectoDao.findAll();
        return lista;
    }
    
}
