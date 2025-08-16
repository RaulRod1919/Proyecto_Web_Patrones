
package com.GRS.dao;

import com.GRS.domain.Proyecto;
import com.GRS.domain.Usuarios;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Raul
 */
public interface ProyectoDao extends JpaRepository<Proyecto, Long> {
    public List<Proyecto> findByIdProyectoOrFechaInicioOrFechaCierreOrUsuarioOrEstado(Long idProyecto,
            LocalDate fechaInicio, LocalDate fechaCierre, Usuarios usuario, String estado);
    
    public List<Proyecto> findByUsuario(Usuarios usuario);
}
