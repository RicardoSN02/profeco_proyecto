/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cliente.comentariosmicroservicios.controller;

import com.cliente.comentariosmicroservicios.entity.Comentario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.cliente.comentariosmicroservicios.repository.ComentarioRepository;

/**
 *
 * @author rjsaa
 */
@RestController
@RequestMapping("api/comentarios")
public class ComentarioController {
    @Autowired
    private ComentarioRepository comentarioRepository;
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Comentario> getAllAccounts(){
        return comentarioRepository.findAll();
        
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
    public void createAccount(@RequestBody Comentario comentario){
        comentarioRepository.save(comentario);
    }
}
