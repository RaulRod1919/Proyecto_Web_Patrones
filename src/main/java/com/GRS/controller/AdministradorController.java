
package com.GRS.controller;

import com.GRS.services.UsuariosService;
import com.GRS.domain.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    public String usuarioModificar(Usuarios usuario, RedirectAttributes redirectAttributes){
        Usuarios user = usuarioService.getUsuariosPorCorreo(usuario.getCorreo());
        if(user != null && new BCryptPasswordEncoder().matches(usuario.getPassword(), user.getPassword())){
            user.setRol(usuario.getRol());
            usuarioService.save(user, false);
            redirectAttributes.addFlashAttribute("mensaje", "Usuario actualizado correctamente.");
            return "redirect:/administrador/gestionUsuarios";
        }else{
            redirectAttributes.addFlashAttribute("error", "El usuario con el correo '" + usuario.getCorreo() + "' no existe.");
            return "redirect:/administrador/gestionUsuarios";
        }
    }
}
