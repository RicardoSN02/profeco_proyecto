/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cliente.comentariosmicroservicios.repository;

import com.cliente.comentariosmicroservicios.entity.Comentario;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author rjsaa
 */
public interface ComentarioRepository extends MongoRepository<Comentario,String>{
    
}
