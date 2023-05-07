/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cliente.authservice.controller;

import com.cliente.authservice.dt.AuthUserDTO;
import com.cliente.authservice.dt.NewUserDto;
import com.cliente.authservice.dt.RequestDto;
import com.cliente.authservice.dt.TokenDto;
import com.cliente.authservice.entity.AuthUser;
import com.cliente.authservice.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rjsaa
 */
@RestController
@RequestMapping("/auth")
public class AuthUserController {
    
    @Autowired
    AuthUserService authUserService;
    
    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody AuthUserDTO dto){
        TokenDto tokenDto = authUserService.login(dto);
        if(tokenDto == null){
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(tokenDto);
        
    }
    
    @PostMapping("/validate")
    public ResponseEntity<TokenDto> validate(@RequestParam String token,@RequestBody RequestDto dto){
        TokenDto tokenDto = authUserService.validate(token,dto);
        if(tokenDto == null){
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(tokenDto);
    }
    
    @PostMapping("/create")
    public ResponseEntity<AuthUser> create(@RequestBody NewUserDto dto){
        AuthUser auth = authUserService.save(dto);
        if(auth == null){
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(auth);
    }
}
