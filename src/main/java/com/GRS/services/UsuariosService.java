package com.GRS.services;

import com.GRS.domain.Usuarios;

import java.util.List;

public interface UsuariosService {


    // Se obtiene un listado de usuarios en un List
    public List<Usuarios> getUsuarios();

    // Se obtiene un Usuarios, a partir del id de un categoria
    
    public Usuarios getUsuarios(Usuarios usuario);
    // Se obtiene un Usuario, a partir del username de un usuario
    public Usuarios getUsuarioPorUsername(String username);

    // Se obtiene un Usuario, a partir del username y el password de un usuario
    public Usuarios getUsuarioPorUsernameYPassword(String username, String password);
    
    // Se obtiene un Usuario, a partir del username y el password de un usuario
    public Usuarios getUsuarioPorUsernameOCorreo(String username, String correo);
    
    // Se valida si existe un Usuario considerando el username
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo);
    // Se inserta un nuevo Usuarios si el id del Usuario esta vacío
    // Se actualiza un Usuarios si el id del Usuario NO esta vacío
    public void save(Usuarios usuarios, boolean crearRolUser);

    // Se elimina el Usuario que tiene el id pasado por parámetro
    public void delete(Usuarios usuarios);

    public Usuarios getUsuariosPorCorreo(String correo);

}
