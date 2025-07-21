package com.GRS.services;

import com.GRS.domain.ProyectosRealizados;

import java.util.List;

public interface ProyectosRealizadosService {

    //Traer Proyectos
    public List<ProyectosRealizados> getProyectos(boolean activos);

    // Se obtiene el proyecto por id
    public  ProyectosRealizados getProyectos(ProyectosRealizados proyecto);

    //se inserta por id
    public void save(ProyectosRealizados proyectos);

    // se elimina por id
    public void delete(ProyectosRealizados proyectos);

    // traer proyectos por id
    public ProyectosRealizados getProyecto(Long id);
}