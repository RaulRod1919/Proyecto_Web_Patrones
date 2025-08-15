
package com.GRS.services;
import jakarta.mail.MessagingException;
/**
 *
 * @author Raul
 */
public interface CorreoService {
    public void enviarCorreoHtml(
            String para, 
            String asunto, 
            String contenidoHtml) 
            throws MessagingException;
    
    public void enviarCorreoEmpresa(
            String correo, 
            String asunto, 
            String contenidoHtml) 
            throws MessagingException;
}
