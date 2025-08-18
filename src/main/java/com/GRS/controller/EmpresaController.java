/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GRS.controller;
import com.GRS.domain.ProyectosRealizados;
import com.GRS.services.EmpresaService;
import com.GRS.services.ProyectosRealizadosService;
import com.GRS.services.TiposConstruccionService;
import com.GRS.servicesImpl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/**
 *
 * @author Raul
 */
@Controller
@RequestMapping("/home")
public class EmpresaController {
    
    @Autowired
    private EmpresaService empresaService;
    
    @Autowired
    private TiposConstruccionService tiposConstruccionService;
    
    @Autowired
    private ProyectosRealizadosService proyectosService;
    
    @GetMapping("/quienes-somos")
    public String getinicio(Model model){
        model.addAttribute("empresa", empresaService.getEmpresa());
        return "home/quienes-somos";
    }
    
    @GetMapping("/tiposCons")
    public String getTiposContruccion(Model model){
        model.addAttribute("empresa", empresaService.getEmpresa());
        model.addAttribute("tiposConstrucciones", tiposConstruccionService.getTiposConstruccion());
        return "home/tiposCons";
    }
    
    @GetMapping("/proyectos")
    public String proyectos(Model model){
        model.addAttribute("proyectosTotales", proyectosService.getProyectos().size());
        model.addAttribute("proyectos", proyectosService.getProyectos());
        model.addAttribute("proyecto", new ProyectosRealizados());
        return "/home/proyectos";
    }
    
    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable("id") Long id, Model model) {
        model.addAttribute("proyecto", proyectosService.getProyecto(id));
        return "home/detalle";
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/save")
    public String guardar(ProyectosRealizados proyecto,
            @RequestParam("imagenFile") MultipartFile imagenFile,
            RedirectAttributes redirectAttributes){
        proyecto.setIdEmpresa(Long.valueOf(1));
        proyectosService.save(proyecto);
        if (!imagenFile.isEmpty()) {
                String rutaImagen = firebaseStorageService.cargaImagen(imagenFile, "proyecto", proyecto.getIdProyectoRealizado());
                proyecto.setRutaImagen(rutaImagen); // Asegúrate de que exista este campo en tu entidad Proyecto
                proyectosService.save(proyecto); // Guardar nuevamente con la ruta de la imagen
            } else {
        // Mantener la imagen existente si no se sube una nueva
        if (proyecto.getIdProyectoRealizado() != null) {
            ProyectosRealizados proyectoExistente = proyectosService.getProyecto(proyecto.getIdProyectoRealizado());
            proyecto.setRutaImagen(proyectoExistente.getRutaImagen());
        }
    }
        return "redirect:/home/proyectos";
    }
    
    @GetMapping("/editar/{id}")
    public String vistaEditar(@PathVariable("id") Long id, Model model){
        model.addAttribute("proyecto", proyectosService.getProyecto(id));
        return "/home/editar";
    }
    
    @GetMapping("/eliminar/{idProyecto}")
    public String eliminar(@PathVariable("idProyecto") Long idProyecto) {
        ProyectosRealizados proyecto = new ProyectosRealizados();
        proyecto.setIdProyectoRealizado(idProyecto);
        proyectosService.delete(proyecto);
        return "redirect:/home/proyectos";
    }
}
