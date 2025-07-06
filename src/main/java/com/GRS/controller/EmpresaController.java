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
    
    @GetMapping("/tiposCons")
    public String getInfo(Model model){
        model.addAttribute("empresa", empresaService.getEmpresa());
        return "home/tiposCons";
    }
    
    @GetMapping("/proyectos")
    public String index(Model model){
        model.addAttribute("empresa", empresaService.getEmpresa());
        return "home/proyectos";
    }
    
}
