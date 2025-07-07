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
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Telefonos getTelefonos(Telefonos telefonos) {
        return telefonosDao.findById(telefonos.getIdTelefono()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Telefonos telefonos) {
        telefonosDao.save(telefonos);
    }

    @Override
    public void delete(Telefonos telefonos) {
        telefonosDao.delete(telefonos);
    }
}
