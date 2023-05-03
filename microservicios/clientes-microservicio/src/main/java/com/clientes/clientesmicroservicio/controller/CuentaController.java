/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clientes.clientesmicroservicio.controller;

import com.clientes.clientesmicroservicio.entity.CuentasEntidad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.clientes.clientesmicroservicio.repository.CuentaRepository;

/**
 *
 * @author rjsaa
 */
@RestController
@RequestMapping("api/cuentas")
public class CuentaController {
    
    @Autowired
    private CuentaRepository cuentaRepository;
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CuentasEntidad> getAllAccounts(){
        return cuentaRepository.findAll();
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
    public void createAccount(@RequestBody CuentasEntidad cuentaEntidad){
        cuentaRepository.save(cuentaEntidad);
    }
}
