package com.GRS.dao;

import com.GRS.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosDao extends JpaRepository<Usuarios, String> {
    Usuarios findByCorreo(String correo);
}
