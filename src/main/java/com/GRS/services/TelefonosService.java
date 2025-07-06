package com.GRS.services;

import com.GRS.domain.Telefonos;

import java.util.List;

public interface TelefonosService {

    // Se obtiene un listado de telefonos
    public List<Telefonos> getTelefonos(boolean activos);

    //Se obtiene un telefonos a partir del id
    public Telefonos getTelefonos(Telefonos telefonos);

    // Se inserta un nuevo telefono si el id del categoria esta vacío
    // Se actualiza un telefono si el id del categoria NO esta vacío
    public void save(Telefonos telefonos);

    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Telefonos telefonos);

}
