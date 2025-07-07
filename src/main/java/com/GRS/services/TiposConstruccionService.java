
package com.GRS.services;
import com.GRS.domain.TiposConstruccion;
import java.util.List;
/**
 *
 * @author Raul
 */

public interface TiposConstruccionService {
    
    public List<TiposConstruccion> getTiposConstruccion();
    
    public TiposConstruccion getTipoConstruccion(TiposConstruccion tipo);
    
}
