/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cliente.comentariosmicroservicios.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author rjsaa
 */
@Document(value= "comentario")
@Getter
@Setter
@NoArgsConstructor
public class Comentario {
    @Id
    private String id;
    private String id_producto;
    private String comentario;
    private int calificacion;
}
