/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GRS.controller;

import com.GRS.domain.Contacto;
import com.GRS.dao.ContactoDao;
import com.GRS.services.ContactoService;
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
@RequestMapping("/contacto")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @GetMapping("/contacto")
    public String mostrarFormulario(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "contacto";
    }

}
