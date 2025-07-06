package com.GRS.dao;

import com.GRS.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Raul
 */
public interface EmpresaDao extends JpaRepository<Empresa, Long>{
    
}
