
package com.GRS.services;

import com.GRS.domain.Proyecto;
import com.GRS.domain.Usuarios;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Raul
 */
public interface ProyectoService {
    
    public void save(Proyecto proyecto);
    
    public void delete(Proyecto proyecto);
    
    public Proyecto getProyecto(Proyecto proyecto);
    
    public List<Proyecto> getProyectos();
    
    public List<Proyecto> findByIdProyectoOrFechaInicioOrFechaCierreOrUsuarioOrEstado(Long idProyecto,
            LocalDate fechaInicio, LocalDate fechaCierre, Usuarios usuario, String estado);
    
}
