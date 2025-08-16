/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GRS.controller;

import com.GRS.domain.Usuarios;
import com.GRS.services.ContactoService;
import com.GRS.services.UsuariosService;
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
@RequestMapping("/contacto")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;
    

    @GetMapping("/solicitudReunion")
    public String mostrarFormulario(Model model, HttpSession session) {
        Usuarios user = (Usuarios)session.getAttribute("usuario");
        model.addAttribute("correo", user.getCorreo());
        return "/contacto/solicitudReunion";
    }
    
    @PostMapping("/enviar")
    public String enviarCorreo(@RequestParam("correo") String correo, 
            @RequestParam("asunto") String asunto,
            @RequestParam("detalle") String detalle) throws MessagingException{
        contactoService.enviarCorreo(asunto, correo, detalle);
        return "redirect:/contacto/solicitudReunion";
    }
    

}
