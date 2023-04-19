/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clientes.productosmicroservicio.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author rjsaa
 */
@Document(value= "producto")
@Getter
@Setter
@NoArgsConstructor
public class ProductosEntidad {
    @Id
    private String id;
    private String nombre;
    private String Descripcion;
    private Float precio;
}
