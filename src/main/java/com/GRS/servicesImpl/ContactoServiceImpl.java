/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GRS.servicesImpl;
import com.GRS.domain.Contacto;
import com.GRS.dao.ContactoDao;
import com.GRS.services.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Raul
 */
@Service
public class ContactoServiceImpl implements ContactoService{
    @Autowired
    private ContactoDao contactoDao;

    @Override
    @Transactional
    public void save(Contacto contacto) {
        contactoDao.save(contacto);
    }
    
    
}
