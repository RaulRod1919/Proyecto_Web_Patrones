/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GRS.servicesImpl;
import com.GRS.services.ContactoService;
import com.GRS.services.CorreoService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Raul
 */
@Service
public class ContactoServiceImpl implements ContactoService{

    @Autowired
    private CorreoService correoService;
    
    
    String contenidoHtml = """
        <html>
            <body>
                <h1 style="color: #4CAF50;">Nueva Duda Recibida</h1>
                <p>Hola equipo,</p>
                <p>Se ha recibido una nueva duda o pregunta desde el formulario de contacto:</p>
                <p><strong>Email:</strong> %s</p>
                <p><strong>Asunto:</strong> %s</p>
                <p><strong>Mensaje:</strong></p>
                <p>%s</p>
                <hr>
                <small>Este mensaje fue generado automáticamente por el sistema. No responder a este correo.</small>
            </body>
        </html>
        """;
    
    @Override
    public void enviarCorreo(String asunto, String correo, String detalle) throws MessagingException{
        detalle = contenidoHtml.formatted(correo, asunto, detalle);
        correoService.enviarCorreoEmpresa(correo, asunto, detalle);
    }
    
    
}
