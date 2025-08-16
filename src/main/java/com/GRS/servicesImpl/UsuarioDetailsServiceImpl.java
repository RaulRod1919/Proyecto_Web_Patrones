package com.GRS.servicesImpl;

import com.GRS.services.UsuarioDetailsService;
import com.GRS.dao.UsuariosDao;
import com.GRS.domain.Usuarios;
import jakarta.servlet.http.HttpSession;//Estudiar lo que hace
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;//Estudiar lo que hace
import org.springframework.security.core.authority.SimpleGrantedAuthority; //Estudiar lo que hace
import org.springframework.security.core.userdetails.*;//Estudiar lo que hace
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {
    @Autowired
    private UsuariosDao usuarioDao;
    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Busca el usuario por el username en la tabla
        Usuarios usuario = usuarioDao.findByUsername(username);
        //Si no existe el usuario lanza una excepción
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        session.setAttribute("usuario", usuario);
        //Si está acá es porque existe el usuario... sacamos los roles que tiene
        var roles = new ArrayList<GrantedAuthority>();
        //Se sacan los roles
        roles.add(new SimpleGrantedAuthority("ROLE_"+usuario.getRol()));
        //Se devuelve User (clase de userDetails)
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
}