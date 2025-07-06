/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GRS.controller;
import com.GRS.domain.Servicios;
import com.GRS.dao.ServiciosDao;
import com.GRS.services.ServiciosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Raul
 */
@Controller
@RequestMapping("/servicios")
public class ServiciosController {
    
    @Autowired
    private ServiciosService serviciosService;
    
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
}
