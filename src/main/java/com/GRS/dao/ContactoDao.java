package com.GRS.dao;

import com.GRS.domain.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Raul
 */
public interface ContactoDao extends JpaRepository<Contacto, Long>{
    
}
