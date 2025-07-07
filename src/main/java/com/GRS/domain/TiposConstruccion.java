
package com.GRS.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Raul
 */
@Data
@Entity
@Table(name="tipos_construcciones")
public class TiposConstruccion implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tipo_construccion")
    private Long idTipoConstruccion;
    @Column(name="id_empresa")
    private Long idEmpresa;
    private String nombre;
    private String descripcion;

    public TiposConstruccion(Long idEmpresa, String nombre, String descripcion) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public TiposConstruccion() {
    }
    
}
