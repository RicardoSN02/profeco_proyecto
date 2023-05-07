/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cliente.authservice.security;

import com.cliente.authservice.dt.RequestDto;
import com.cliente.authservice.entity.AuthUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 *
 * @author rjsaa
 */
@Component
//@ComponentScan("com.cliente.authservice.security")
public class JwtProvider {
    

    @Value("${jwt.secret}")
    private String secret;
    
    @Autowired
    RouteValidator routeValidator;
    
    @PostConstruct
    protected void init(){
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }
    
    public String createToken(AuthUser authUser){
        Map<String,Object> claims = new HashMap<>();
        claims = Jwts.claims().setSubject(authUser.getUserName());
        claims.put("id",authUser.getId());
        claims.put("role", authUser.getRole());
        Date now = new Date();
        Date exp= new Date(now.getTime()+3600000);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
    
    public boolean validate(String token,RequestDto dto){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            
        }catch(Exception e){
            return false;
        }
        if(!isAdmin(token) && routeValidator.isAdminPath(dto)){
            return false;
        }else{
            return true;
        }
    }
    
    public String getUserNameFromToken(String token){
        try{
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
        }catch(Exception e){
            return "bad token";
        }
    }
    
    private boolean isAdmin(String token){
        return Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token).getBody().get("role").equals("admin");
    }
}

