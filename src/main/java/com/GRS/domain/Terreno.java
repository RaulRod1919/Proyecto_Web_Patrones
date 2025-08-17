
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
@Table(name="tipos_terrenos")
public class Terreno {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_terreno")
    private Long idTerreno;
    @ManyToOne
    @JoinColumn(name="id_empresa", updatable=false)
    private Empresa empresa;
}
