package com.GRS.servicesImpl;

import com.GRS.dao.UsuariosDao;
import com.GRS.domain.Usuarios;
import com.GRS.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosDao usuariosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> getUsuarios(boolean activos) {
        var lista = usuariosDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios getUsuarios(Usuarios usuarios) {
        return usuariosDao.findById(usuarios.getCorreo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Usuarios usuarios) {
        usuariosDao.save(usuarios);
    }

    @Override
    @Transactional
    public void delete(Usuarios usuarios) {
        usuariosDao.delete(usuarios);
    }

    // método para buscar por correo directamente
    @Override
    @Transactional(readOnly = true)
    public Usuarios getUsuariosPorCorreo(String correo) {
        return usuariosDao.findById(correo).orElse(null);
    }
}
