/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GRS.controller;
import com.GRS.domain.Servicios;
import com.GRS.domain.Usuarios;
import com.GRS.services.AcabadoService;
import com.GRS.services.PresupuestoService;
import com.GRS.services.ServiciosService;
import com.GRS.services.TerrenoService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Raul
 */
@Controller
@RequestMapping("/servicios")
public class ServiciosController {
    
    @Autowired
    private ServiciosService serviciosService;
    
    @Autowired
    private TerrenoService terrenoService;
    
    @Autowired
    private AcabadoService acabadoService;
    
    @Autowired
    private PresupuestoService presupuestoService;
    
    @GetMapping("/lista")
    public String servicios(Model model){
        model.addAttribute("servicios", serviciosService.getServicios());
        return "/servicios/lista";
    }
    
    @GetMapping("/paqueteCompleto/{idServicio}")
    public String paqueteCompleto(Model model, Servicios servicio){
        model.addAttribute("servicio", serviciosService.getServicio(servicio));
        return "/servicios/paqueteCompleto";
    }
    
    @GetMapping("soloConstruccion/{idServicio}")
    public String soloConstruccion(Model model, Servicios servicio){
        model.addAttribute("servicio", serviciosService.getServicio(servicio));
        return "/servicios/soloConstruccion";
    }
    
    @GetMapping("/disenoConstruccion/{idServicio}")
    public String disenoContruccion(Model model, Servicios servicio){
        model.addAttribute("servicio", serviciosService.getServicio(servicio));
        return "/servicios/disenoConstruccion";
    }
    
    @GetMapping("/presupuesto")
    public String vistaPresupuesto(Model model){
        model.addAttribute("terrenos", terrenoService.getTerrenos());
        model.addAttribute("acabados", acabadoService.getAcabados());
        return "/servicios/presupuesto";
    }
    
    @PostMapping("/enviar")
    public String envioCorreo(HttpSession session, @RequestParam("area") Double area,
        @RequestParam("acabados") String acabado,
        @RequestParam("terreno") String tipoTerreno,
        @RequestParam("ubicacion") String ubicacionLink) throws MessagingException{
        Usuarios user = (Usuarios)session.getAttribute("usuario");
        String contenidoHtml = """
                <p><strong>Tipo de terreno:</strong> %s</p>
                <p><strong>Tipo de Acabado:</strong> %s</p>
                <p><strong>Área:</strong> %s mt2</p>
                <p><strong>Ubicación:</strong> %s</p>
        """;
        contenidoHtml = contenidoHtml.formatted( tipoTerreno, acabado, area, ubicacionLink);
        presupuestoService.enviarCorreo(user.getCorreo(), contenidoHtml);
        return "redirect:/servicios/presupuesto";
    }
}
