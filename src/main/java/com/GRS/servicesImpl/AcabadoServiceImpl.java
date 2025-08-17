/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GRS.servicesImpl;

import com.GRS.dao.AcabadoDao;
import com.GRS.domain.Acabado;
import com.GRS.services.AcabadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Raul
 */
@Service
public class AcabadoServiceImpl implements AcabadoService {

    @Autowired
    private AcabadoDao acabadoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Acabado> getAcabados() {
        List lista = acabadoDao.findAll();
        return lista;
    }
    
}
