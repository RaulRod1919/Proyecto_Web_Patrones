package com.GRS.controller;

import com.GRS.domain.Proyecto;
import com.GRS.domain.Usuarios;
import com.GRS.services.ProyectoService;
import com.GRS.services.UsuariosService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/proyectos")
public class InformacionController {

    @Autowired
    private ProyectoService proyectoService;
    
    @Autowired
    private UsuariosService usuarioService;

    @GetMapping("/informacion")
    public String mostrarProyectos(Model model, HttpSession session) {
        Usuarios user = (Usuarios)session.getAttribute("usuario");
        model.addAttribute("proyectos", proyectoService.findByUsuario(user));
        return "proyectos/informacion"; // apunta a: templates/proyectos/informacion.html
    }

    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable("id") Long id, Model model) {
        Proyecto proyecto = new Proyecto();
        proyecto.setIdProyecto(id);
        model.addAttribute("proyecto", proyectoService.getProyecto(proyecto));
        return "proyectos/detalle";
    }

}