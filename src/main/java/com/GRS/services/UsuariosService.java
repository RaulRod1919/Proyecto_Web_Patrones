package com.GRS.services;

import com.GRS.domain.Usuarios;

import java.util.List;

public interface UsuariosService {


    // Se obtiene un listado de usuarios en un List
    public List<Usuarios> getUsuarios(boolean activos);

    // Se obtiene un Usuarios, a partir del id de un categoria
    public Usuarios getUsuarios(Usuarios usuarios);

    // Se inserta un nuevo Usuarios si el id del Usuario esta vacío
    // Se actualiza un Usuarios si el id del Usuario NO esta vacío
    public void save(Usuarios usuarios);

    // Se elimina el Usuario que tiene el id pasado por parámetro
    public void delete(Usuarios usuarios);

    public Usuarios getUsuariosPorCorreo(String correo);

}
