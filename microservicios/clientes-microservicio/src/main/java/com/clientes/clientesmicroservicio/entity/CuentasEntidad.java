/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clientes.clientesmicroservicio.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author rjsaa
 */
@Document(value= "cuenta")
@Getter
@Setter
@NoArgsConstructor
public class CuentasEntidad {
    @Id
    private String id;
    private String nombre;
    private String password;
}
