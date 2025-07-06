/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GRS.controller;
import com.GRS.domain.Empresa;
import com.GRS.dao.EmpresaDao;
import com.GRS.services.EmpresaService;
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
@RequestMapping("/home")
public class EmpresaController {
    
    @Autowired
    private EmpresaService empresaService;
    
    @GetMapping("/quienes-somos")
    public String getinicio(Model model){
        model.addAttribute("empresa", empresaService.getEmpresa());
        return "home/quienes-somos";
    }
    
    @GetMapping("/tiposCons")
    public String getTiposContruccion(Model model){
        model.addAttribute("empresa", empresaService.getEmpresa());
        return "home/tiposCons";
    }
    
    @GetMapping("/proyectos")
    public String getProyectos(Model model){
        model.addAttribute("empresa", empresaService.getEmpresa());
        return "home/proyectos";
    }
    
}
