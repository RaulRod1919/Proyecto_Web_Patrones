/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.GRS.services;

import com.GRS.domain.Usuarios;
import jakarta.mail.MessagingException;
import org.springframework.ui.Model;

/**
 *
 * @author Raul
 */
public interface RegistroService {
    
    public Model verificar(Usuarios usuario, Model model);
    
    public void activar(Model model, Usuarios usuario) throws MessagingException;
    
    public void crearUser(Usuarios usuario, Model model) throws MessagingException;
    
}
