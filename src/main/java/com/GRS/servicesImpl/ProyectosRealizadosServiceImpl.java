package com.GRS.servicesImpl;

import com.GRS.dao.ProyectosRealizadosDao;
import com.GRS.domain.ProyectosRealizados;
import com.GRS.services.ProyectosRealizadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProyectosRealizadosServiceImpl implements ProyectosRealizadosService {

    @Autowired
    private ProyectosRealizadosDao proyectosDao;

    @Override
    @Transactional(readOnly = true)
    public List<ProyectosRealizados> getProyectos(boolean activos) {
        var lista = proyectosDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public ProyectosRealizados getProyectos(ProyectosRealizados proyecto) {
        return proyectosDao.findById(proyecto.getIdProyecto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(ProyectosRealizados proyectos) {
        proyectosDao.save(proyectos);
    }

    @Override
    public void delete(ProyectosRealizados proyectos) {
         proyectosDao.delete(proyectos);
    }

    @Override
    @Transactional(readOnly = true)
    public ProyectosRealizados getProyecto(Long id) {
        return proyectosDao.findById(id).orElse(null);
    }

}
