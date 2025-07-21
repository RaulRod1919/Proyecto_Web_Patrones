package com.GRS.controller;

import com.GRS.domain.ProyectosRealizados;
import com.GRS.services.ProyectosRealizadosService;
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
    private ProyectosRealizadosService proyectosService;

    @GetMapping("/informacion")
    public String mostrarProyectos(Model model) {
        List<ProyectosRealizados> proyectos = proyectosService.getProyectos(true); // o false si no usás "activo"
        model.addAttribute("proyectos", proyectos);
        return "proyectos/informacion"; // apunta a: templates/proyectos/informacion.html
    }

    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable("id") Long id, Model model) {
        ProyectosRealizados proyecto = proyectosService.getProyecto(id);
        model.addAttribute("proyecto", proyecto);
        return "proyectos/detalle";
    }

}