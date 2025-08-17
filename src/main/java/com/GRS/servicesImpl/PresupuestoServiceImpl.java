/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GRS.servicesImpl;

import com.GRS.services.CorreoService;
import com.GRS.services.PresupuestoService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Raul
 */
@Service
public class PresupuestoServiceImpl implements PresupuestoService{

    @Autowired
    private CorreoService correoService;
    
    @Override
    @Transactional
    public void enviarCorreo(String correo, String detalle) throws MessagingException {
        String contenidoHtml = """
        <html>
            <body>
                <h1 style="color: #4CAF50;">Nueva Solicitud de Presupuesto</h1>
                <p>Hola equipo,</p>
                <p>Se ha recibido una nueva solicitud de presupuesto</p>
                <p><strong>Solicitante:</strong> %s</p>
                <p><strong>Asunto:</strong>Presupuesto</p>
                <p><strong></strong></p>
                %s
                <hr>
                <small>Este mensaje fue generado automáticamente por el sistema. No responder a este correo.</small>
            </body>
        </html>
        """;
        contenidoHtml = contenidoHtml.formatted(correo, detalle);
        correoService.enviarCorreoEmpresa(correo, "Presupuesto", contenidoHtml);
    }
    
    
}
