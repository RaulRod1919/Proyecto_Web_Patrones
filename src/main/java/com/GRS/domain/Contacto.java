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
    private Integer idContacto;
    private String asunto;
    private String email;
    private String telefono;
    private String detalle;

    public Contacto(Integer idContacto, String asunto, String email, String telefono, String detalle) {
        this.idContacto = idContacto;
        this.asunto = asunto;
        this.email = email;
        this.telefono = telefono;
        this.detalle = detalle;
    }

    public Contacto() {
    }

}
