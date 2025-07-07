package com.GRS.controller;

import com.GRS.domain.Telefonos;
import com.GRS.services.TelefonosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/telefono")
public class TelefonosController {

    @Autowired
    private TelefonosService telefonosService;

    // Traer Objetos
    @GetMapping("/listado")
    public String telefonos (Model model){
        var lista = telefonosService.getTelefonos(false);
        model.addAttribute("telefonos",lista);
        model.addAttribute("totalTelefonos",lista.size());
        return "/telefono/listado";

    }

    // Aqui deberia de ir el PostMapping
    @PostMapping("/guardar")
    public String telefonosGuardar(Telefonos telefonos){
        telefonosService.save(telefonos);
        return "redirect:/telefono/listado";
    }

    //GetMapping osea eliminar
   @GetMapping ("/eliminar/{idTelefono}")
    public String telefonosEliminar(Telefonos telefonos){
        telefonosService.delete(telefonos);
        return "redirect:/telefono/listado";
   }

   //GetMapping osea Modificar
    @GetMapping("/modificar/{idTelefono}")
    public String telefonosModificar (Telefonos telefono,Model model){
        telefono = telefonosService.getTelefonos(telefono);
        model.addAttribute("telefono", telefono);
        return "/telefono/modifica";
    }

}
