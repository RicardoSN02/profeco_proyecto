/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cliente.wishlistmicroservicios.repository;

import com.cliente.wishlistmicroservicios.entity.WishlistEntidad;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author rjsaa
 */
public interface WishlistRepository extends MongoRepository<WishlistEntidad,String> {
    
}
