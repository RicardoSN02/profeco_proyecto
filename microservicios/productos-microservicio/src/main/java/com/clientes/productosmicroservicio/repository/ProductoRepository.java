/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.clientes.productosmicroservicio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.clientes.productosmicroservicio.entity.ProductosEntidad;

/**
 *
 * @author rjsaa
 */
public interface ProductoRepository extends MongoRepository<ProductosEntidad,String> {
    
}
