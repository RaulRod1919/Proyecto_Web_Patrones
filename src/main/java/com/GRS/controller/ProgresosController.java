package com.GRS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/proyectos")
public class ProgresosController {

    @GetMapping("/progresos")
    public String mostrarProgresos() {
        return "proyectos/progresos";
    }

}
