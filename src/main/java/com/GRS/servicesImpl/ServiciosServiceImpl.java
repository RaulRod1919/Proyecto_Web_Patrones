/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GRS.servicesImpl;
import com.GRS.domain.Servicios;
import com.GRS.dao.ServiciosDao;
import com.GRS.services.ServiciosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Raul
 */
@Service
public class ServiciosServiceImpl implements ServiciosService {

    @Autowired
    private ServiciosDao serviciosDao;
    
    @Override
    @Transactional(readOnly = true)
    public List getServicios() {
        List list = serviciosDao.findAll();
        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public Servicios getServicio(Servicios servicio) {
        return serviciosDao.findById(servicio.getIdServicio()).orElse(null);
    }
    
}
