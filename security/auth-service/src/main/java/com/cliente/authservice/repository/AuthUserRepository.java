/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cliente.authservice.repository;

import com.cliente.authservice.entity.AuthUser;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author rjsaa
 */
@Repository
public interface AuthUserRepository extends MongoRepository<AuthUser,String>{
    Optional<AuthUser> findByUserName(String username);
}
