/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GRS.servicesImpl;

import com.GRS.domain.Usuarios;
import com.GRS.services.CorreoService;
import com.GRS.services.RegistroService;
import com.GRS.services.UsuariosService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 *
 * @author Raul
 */
@Service
public class RegistroServiceImpl implements RegistroService {

    @Autowired
    private CorreoService correo;

    @Autowired
    private UsuariosService usuarioService;

    @Value("${servidor.http}")
    private String servidor;

    String contenidoHtml = """
    <html>
        <body>
            <h1 style="color: #4CAF50;">Activación de cuenta</h1>
            <p>Hola <strong>%s</strong>,</p>
            <p>Gracias por registrarte en nuestra tienda. Para activar tu cuenta, por favor haz clic en el siguiente enlace:</p>
            <p><a href="http://%s/activar/%s" 
                  style="background-color: #4CAF50; color: white; padding: 10px 15px; text-decoration: none; border-radius: 5px;">
                Activar Cuenta
            </a></p>
            <p>Si no solicitaste esta cuenta, puedes ignorar este mensaje.</p>
            <hr>
            <small>Este mensaje fue enviado automáticamente. No responda a este correo.</small>
        </body>
    </html>
    """;

    @Override
    public Model verificar(Usuarios usuario, Model model) {

        Usuarios user = usuarioService.getUsuarioPorUsernameOCorreo(usuario.getUsername(), usuario.getCorreo());
        if (user == null) {
            model.addAttribute("usuario", usuario);
        } else {
            model.addAttribute("mensaje", "El nombre de usuario o correo electrónico ya han sido utilizados");
        }
        return model;
    }

    @Override
    public void activar(Model model, Usuarios usuario) throws MessagingException {
        String clave = new BCryptPasswordEncoder().encode(demeClave());
        usuario.setPassword(clave);
        usuarioService.save(usuario, true);
        model.addAttribute("mensaje", "Se ha enviado un correo a cu direccion " + usuario.getCorreo() + " Favor de realizar la activacion");
        contenidoHtml = contenidoHtml.formatted(usuario.getUsername(), servidor, usuario.getUsername());
        correo.enviarCorreoHtml(usuario.getCorreo(), "Activacion de Cuenta", contenidoHtml);
    }

    @Override
    public void crearUser(Usuarios usuario, Model model) throws MessagingException {

    }

    private String demeClave() {
        String tira = "ABCDEFGHIJKLMNOPQRSTUXYZabcdefghijklmnopqrstuvwxyz0123456789_*+-";
        String clave = "";
        for (int i = 0; i < 40; i++) {
            clave += tira.charAt((int) (Math.random() * tira.length()));
        }
        return clave;
    }

}
