/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.GRS.services;

import jakarta.mail.MessagingException;

/**
 *
 * @author Raul
 */
public interface PresupuestoService {
    
    public void enviarCorreo(String correo, String detalle) throws MessagingException;
    
}
