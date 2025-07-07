package com.GRS.controller;

import com.GRS.domain.Telefonos;
import com.GRS.domain.Usuarios;
import com.GRS.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RegistroController {

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping("/registrarse")
    public String registrarUsuario(@RequestParam("nombre") String nombre,
                                   @RequestParam("email") String correo,
                                   @RequestParam("password") String password,
                                   @RequestParam("telefono") String telefono) {

        // Crear el objeto Usuario
        Usuarios usuario = new Usuarios();
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setPassword(password);
        usuario.setRol("USER"); // Rol por defecto

        // Crear el objeto Teléfono
        Telefonos tel = new Telefonos();
        tel.setNombre(telefono);         // Guardamos el número como "nombre"
        tel.setUsuario(usuario);         // Relación inversa

        // Asociar teléfono al usuario
        usuario.setTelefonos(List.of(tel));

        // Guardar el usuario (con teléfono en cascada)
        usuariosService.save(usuario);

        // Redireccionar al inicio de sesión
        return "redirect:/inicio-sesion";
    }
}