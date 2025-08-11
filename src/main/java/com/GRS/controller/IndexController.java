package com.GRS.controller;

import com.GRS.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    
    @Autowired
    private EmpresaService empresaService;

    // Página principal
    @GetMapping({"", "/", "/index"})
    public String index(Model model) {
        model.addAttribute("empresa", empresaService.getEmpresa());
        return "index"; // debe estar en: src/main/resources/templates/index.html
    }

    // Página de registro (si la querés desde aquí también)
    @GetMapping("/registrarse")
    public String mostrarRegistro() {
        return "home/registrarse"; // o donde lo tengas ubicado
    }
}
