/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.clientes.clientesmicroservicio.repository;

import com.clientes.clientesmicroservicio.entity.CuentasEntidad;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author rjsaa
 */
public interface CuentaRepository extends MongoRepository<CuentasEntidad,String>{
    
}
