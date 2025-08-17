
package com.GRS.servicesImpl;

import com.GRS.dao.TerrenoDao;
import com.GRS.domain.Terreno;
import com.GRS.services.TerrenoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TerrenoServiceImpl implements TerrenoService {
    
    @Autowired
    private TerrenoDao terrenoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Terreno> getTerrenos() {
        List<Terreno> lista = terrenoDao.findAll();
        return lista;
    }
    
    
}
