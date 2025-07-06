
package com.GRS.services;
import com.GRS.domain.Servicios;
import java.util.List;
/**
 *
 * @author Raul
 */

public interface ServiciosService {
    
    public List getServicios();
    
    public Servicios getServicio(Servicios servicio);
    
}
