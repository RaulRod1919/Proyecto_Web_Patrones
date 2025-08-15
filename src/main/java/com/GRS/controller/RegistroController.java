package com.GRS.controller;

import com.GRS.domain.Usuarios;
import com.GRS.services.RegistroService;
import com.GRS.services.UsuariosService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import org.springframework.ui.Model;

@Controller
public class RegistroController {

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private RegistroService registroService;
    
    @GetMapping("/home/registrarse")
    public String mostrarRegistro(Model model) {
        return "home/registrarse"; // o donde lo tengas ubicado
    }
    
    @GetMapping("/activar/{username}")
    public String mostrarActivacion(Model model, @PathVariable("username") String username) {
        Usuarios user = new Usuarios();
        user = usuariosService.getUsuarioPorUsername(username);
        model.addAttribute("usuario", user);
        return "home/activar"; // o donde lo tengas ubicado
    }
    

    @PostMapping("/activarse")
    public String activarUsuario(@RequestParam("nombre") String nombre,
            @RequestParam("email") String correo,
            @RequestParam("password") String password, Model model) throws MessagingException {

        var encriptador = new BCryptPasswordEncoder();

        // Crear el objeto Usuario
        Usuarios usuario = new Usuarios();
        usuario.setUsername(nombre);
        usuario.setCorreo(correo);
        usuario.setPassword(encriptador.encode(password));
        model = registroService.verificar(usuario, model);
        if (model.getAttribute("usuario") != null) {
            // Usuario no existía → crear y enviar correo
            registroService.activar(model, usuario);
        }
        // Redireccionar al inicio de sesión
        return "/home/registrarse";
    }

    @PostMapping("/home/activado")
    public String registrarUsuario(Model model, Usuarios user) throws MessagingException {

        var encriptador = new BCryptPasswordEncoder();

        // Crear el objeto Usuario
        user.setPassword(encriptador.encode(user.getPassword()));
        usuariosService.save(user, true);
        // Redireccionar al inicio de sesión
        return "redirect:/index";
    }
}
