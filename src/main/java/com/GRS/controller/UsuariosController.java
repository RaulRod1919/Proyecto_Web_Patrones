package com.GRS.controller;

import com.GRS.domain.Usuarios;
import com.GRS.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/listado")
    public String listado(Model model){
        var lista = usuariosService.getUsuarios();
        model.addAttribute("usuarios",lista);
        model.addAttribute("totalUsuarios",lista.size());
        return "/usuarios/listado";
    }

    @PostMapping("/guardar")
    public String usuarioGuardar (Usuarios usuarios){
        if(usuariosService.existeUsuarioPorUsernameOCorreo(usuarios.getUsername(), usuarios.getCorreo())){
            usuariosService.save(usuarios, false);
        }else{
            usuariosService.save(usuarios, true);
        }
        return "redirect:/usuario/listado";
    }

    @GetMapping("eliminar/{correo}")
    public String usuarioEliminar(Usuarios usuarios){
        usuariosService.delete(usuarios);
        return "redirect:/usuario/listado";
    }

    @GetMapping("/modificar/{correo}")
    public String usuarioModificar(Usuarios usuario, Model model){
        usuario = usuariosService.getUsuarios(usuario);
        model.addAttribute("usuario",usuario);
        return "/usuario/modifica";
    }
}
