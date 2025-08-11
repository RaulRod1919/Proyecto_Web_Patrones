package com.GRS.controller;


import com.GRS.domain.Usuarios;
import com.GRS.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Controller
public class RegistroController {

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping("/registrarse")
    public String registrarUsuario(@RequestParam("nombre") String nombre,
                                   @RequestParam("email") String correo,
                                   @RequestParam("password") String password) {
        
        var encriptador = new BCryptPasswordEncoder();

        // Crear el objeto Usuario
        Usuarios usuario = new Usuarios();
        usuario.setUsername(nombre);
        usuario.setCorreo(correo);
        usuario.setPassword(encriptador.encode(password));
        // Guardar el usuario (con teléfono en cascada)
        usuariosService.save(usuario, true);

        // Redireccionar al inicio de sesión
        return "redirect:/index";
    }
}