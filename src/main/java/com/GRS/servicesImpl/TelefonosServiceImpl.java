package com.GRS.servicesImpl;

import com.GRS.dao.TelefonosDao;
import com.GRS.domain.Telefonos;
import com.GRS.services.TelefonosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TelefonosServiceImpl implements TelefonosService {

    @Autowired
    private TelefonosDao telefonosDao;


    @Override
    @Transactional(readOnly = true)
    public List<Telefonos> getTelefonos(boolean activos) {
        var lista = telefonosDao.findAll();
        if (activos) {
            
        }
        return lista;
    }

    @Override
    public Telefonos getTelefonos(Telefonos telefonos) {
        return null;
    }

    @Override
    public void save(Telefonos telefonos) {

    }

    @Override
    public void delete(Telefonos telefonos) {

    }
}
