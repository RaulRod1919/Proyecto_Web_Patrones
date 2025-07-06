/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GRS.servicesImpl;
import com.GRS.domain.Empresa;
import com.GRS.dao.EmpresaDao;
import com.GRS.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Raul
 */
@Service
public class EmpresaServiceImpl implements EmpresaService{
    @Autowired
    private EmpresaDao empresaDao;

    @Override
    @Transactional(readOnly = true)
    public Empresa getEmpresa() {
        return empresaDao.findById(1L).orElse(null);
    }
}
