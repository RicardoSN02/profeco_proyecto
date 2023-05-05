/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cliente.authservice.service;

import com.cliente.authservice.dt.AuthUserDTO;
import com.cliente.authservice.dt.TokenDto;
import com.cliente.authservice.entity.AuthUser;
import com.cliente.authservice.repository.AuthUserRepository;
import com.cliente.authservice.security.JwtProvider;
import com.cliente.authservice.security.JwtProvider;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author rjsaa
 */
@Service
public class AuthUserService {
    
    @Autowired
    AuthUserRepository authUserRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    JwtProvider jwtProvider;
    
    public AuthUser save(AuthUserDTO dto){
        Optional<AuthUser> user = authUserRepository.findByUserName(dto.getUserName());
        if(!user.isPresent())
            return null;
        
        String password = passwordEncoder.encode(dto.getPassword());
        AuthUser authUser =AuthUser.builder()
                .userName(dto.getUserName())
                .password(password)
                .build();
        
        return authUserRepository.save(authUser);
    }
    
    public TokenDto login(AuthUserDTO dto){
        Optional<AuthUser> user = authUserRepository.findByUserName(dto.getUserName());
        if(!user.isPresent())
            return null;
        
        if(passwordEncoder.matches(dto.getPassword(), user.get().getPassword()))
            return new TokenDto(jwtProvider.createToken(user.get()));
        return null;
    }
    
    public TokenDto validate(String token){
        if(!jwtProvider.validate(token))
            return null;
        String username = jwtProvider.getUserNameFromToken(token);
        if(!authUserRepository.findByUserName(username).isPresent())
            return null;
        return new TokenDto(token);
    }
    
}
