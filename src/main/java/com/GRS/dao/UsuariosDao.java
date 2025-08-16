package com.GRS.dao;

import com.GRS.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosDao extends JpaRepository<Usuarios, String> {
    
    Usuarios findByUsername(String username);
    
    Usuarios findByUsernameAndPassword(String username, String password);
    
    Usuarios findByUsernameOrCorreo(String username, String correo);
    
    boolean existsByUsernameOrCorreo(String username, String correo);
}
