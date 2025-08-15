package com.GRS.services;

import jakarta.mail.MessagingException;

/**
 *
 * @author Raul
 */
public interface ContactoService {
    
    public void enviarCorreo(String asunto, String correo, String detalle) throws MessagingException;
    
}
