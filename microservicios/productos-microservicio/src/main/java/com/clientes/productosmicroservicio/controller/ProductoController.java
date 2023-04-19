/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clientes.productosmicroservicio.controller;

import com.clientes.productosmicroservicio.entity.ProductosEntidad;
import com.clientes.productosmicroservicio.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rjsaa
 */
@RestController
@RequestMapping("api/productos")
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductosEntidad> getAllAccounts(){
        return productoRepository.findAll();
    }
    
  /**  @GetMapping
    public ResponseEntity<List<CuentasEntidad>> getAllAccounts(){
        List<CuentasEntidad> cuentasEntidades = cuentaRepository.findAll();
        ResponseEntity<List<CuentasEntidad>> responseEntity = new ResponseEntity<>(cuentasEntidades,HttpStatus.OK);
        return responseEntity;
    }
   */
    
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createAccount(@RequestBody ProductosEntidad productosEntidad){
        productoRepository.save(productosEntidad);
    }
}
