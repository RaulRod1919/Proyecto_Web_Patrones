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
    public List<Usuarios> getUsuarios() {
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
    public void save(Usuarios usuarios, boolean crearRolUser) {
        if(crearRolUser){
            usuarios.setRol("USER");
            usuariosDao.save(usuarios);
        }else{
            usuariosDao.save(usuarios);
        }
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

    @Override
    @Transactional(readOnly = true)
    public Usuarios getUsuarioPorUsername(String username) {
        return usuariosDao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios getUsuarioPorUsernameYPassword(String username, String password) {
        return usuariosDao.findByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios getUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuariosDao.findByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuariosDao.existsByUsernameOrCorreo(username, correo);
    }
}
