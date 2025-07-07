
package com.GRS.controller;

import com.GRS.services.UsuariosService;
import com.GRS.domain.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Raul
 */
@Controller
@RequestMapping("/administrador")
public class AdministradorController {
    @Autowired
    private UsuariosService usuarioService;
    
    @GetMapping("/gestionUsuarios")
    public String vistaPanel(Model model){
        model.addAttribute("usuario", new Usuarios());
        return "/administrador/gestionUsuarios";
    }
    
    @PostMapping("/actualizar")
    public String usuarioModificar(Usuarios usuario){
        usuario = usuarioService.getUsuarios(usuario);
        usuarioService.save(usuario);
        return "redirect:/administrador/gestionUsuarios";
    }
}
