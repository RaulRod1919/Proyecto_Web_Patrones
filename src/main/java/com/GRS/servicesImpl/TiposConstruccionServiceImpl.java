
package com.GRS.servicesImpl;
import com.GRS.domain.TiposConstruccion;
import java.util.List;
import com.GRS.services.TiposConstruccionService;
import com.GRS.dao.TiposConstruccionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Raul
 */
@Service
public class TiposConstruccionServiceImpl implements TiposConstruccionService {

    @Autowired
    private TiposConstruccionDao tiposConstruccionDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<TiposConstruccion> getTiposConstruccion() {
        List lista = tiposConstruccionDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public TiposConstruccion getTipoConstruccion(TiposConstruccion tipo) {
        return tiposConstruccionDao.findById(tipo.getIdTipoConstruccion()).orElse(null);
    }
    
}
