package com.GRS.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {

    @Id
    @Column(name = "correo")
    private String correo;
    @NotEmpty
    @Column(name = "username")
    private String username;
    @NotEmpty
    @Column(name = "password")
    private String password;

    @Column(name = "rol")
    private String rol;

    public Usuarios() {
    }

    // Este constructor es para crear el User y asignarle los telefonos de una vez
    public Usuarios(String correo, String username, String password, String rol) {
        this.correo = correo;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

}
