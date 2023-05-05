/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cliente.authservice.dt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author rjsaa
 */
/**
 *
 * @author rjsaa
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthUserDTO {
    
    private String userName;
    private String password;
    
}
