package com.GRS.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

/**
 *
 * @author Raul
 */
@Data
@Entity
@Table(name = "contacto")
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contacto")
    private Long idContacto;
    private String asunto;
    private String email;
    private int telefono;
    private String detalle;

    public Contacto(String asunto, String email, int telefono, String detalle) {
        this.asunto = asunto;
        this.email = email;
        this.telefono = telefono;
        this.detalle = detalle;
    }

    public Contacto() {
    }

}
