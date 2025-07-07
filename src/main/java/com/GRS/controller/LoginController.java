package com.GRS.controller;

import com.GRS.domain.Usuarios;
import com.GRS.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping("/iniciar-sesion")
    public String loginUsuario(@RequestParam String correo,
                               @RequestParam String password,
                               Model model) {

        // Buscar usuario por correo
        Usuarios usuario = usuariosService.getUsuarios(new Usuarios(correo, "", "", ""));

        if (usuario != null && usuario.getPassword().equals(password)) {
            // Éxito: redirigir al home
            model.addAttribute("usuario", usuario);
            return "redirect:/"; // o a cualquier página principal
        }

        // Falló el inicio: regresar a inicio con error
        model.addAttribute("error", "Correo o contraseña incorrectos");
        return "home/inicio_sesion";
    }
}