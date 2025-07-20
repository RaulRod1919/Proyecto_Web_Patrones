
package com.GRS.services;

import com.GRS.domain.Proyecto;
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
    
}
