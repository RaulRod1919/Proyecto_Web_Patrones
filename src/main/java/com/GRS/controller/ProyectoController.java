package com.GRS.controller;

import com.GRS.domain.Proyecto;
import com.GRS.domain.Usuarios;
import com.GRS.services.ProyectoService;
import com.GRS.services.ServiciosService;
import com.GRS.services.UsuariosService;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private ServiciosService servicioService;

    @Autowired
    private UsuariosService usuarioService;

    @GetMapping("/panel")
    public String panel(Model model) {
        model.addAttribute("proyectos", proyectoService.getProyectos());
        model.addAttribute("servicios", servicioService.getServicios());
        model.addAttribute("proyecto", new Proyecto());
        return "/proyecto/panel";
    }

    @PostMapping("/guardar")
    public String crear(Proyecto proyecto, RedirectAttributes redirectAttributes) {
        Usuarios user = usuarioService.getUsuariosPorCorreo(proyecto.getUsuario().getCorreo());
        if (user != null) {
            proyecto.setUsuario(user);
            proyectoService.save(proyecto);
            return "redirect:/proyecto/panel";
        } else {
            redirectAttributes.addFlashAttribute("error", "El usuario no existe.");
            return "redirect:/proyecto/panel";
        }
    }

    @GetMapping("/eliminar/{idProyecto}")
    public String eliminar(Proyecto proyecto) {
        proyectoService.delete(proyecto);
        return "redirect:/proyecto/panel";
    }

    @GetMapping("/editar/{idProyecto}")
    public String edit(Model model, Proyecto proyecto) {
        proyecto = proyectoService.getProyecto(proyecto);
        model.addAttribute("servicios", servicioService.getServicios());
        model.addAttribute("proyecto", proyecto);
        return "/proyecto/editar";
    }

    @PostMapping("/filtro")
    public String filtro(Model model, @RequestParam(value = "correo", required = false) String correoUsuario,
            @RequestParam(value = "idProyecto", required = false) Long idProyecto,
            @RequestParam(value = "fechaInicio", required = false) LocalDate fechaInicio,
            @RequestParam(value = "fechaCierre", required = false) LocalDate fechaCierre,
            @RequestParam(value = "estado", required = false) String estado) {
        Usuarios user = null;
        if (correoUsuario != null && !correoUsuario.trim().isEmpty()) {
            user = usuarioService.getUsuariosPorCorreo(correoUsuario);
        }
        model.addAttribute("proyectos", proyectoService.findByIdProyectoOrFechaInicioOrFechaCierreOrUsuarioOrEstado(
                idProyecto, fechaInicio, fechaCierre, user, estado));
        model.addAttribute("proyecto", new Proyecto());
        model.addAttribute("servicios", servicioService.getServicios());
        return "/proyecto/panel";
    }
}
