
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consultas;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entidades.Comentario;
import entidades.Productos;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;
/**
 *
 * @author rjsaa
 */
public class Consultas {

    public Consultas() {
    }
    
    public List<Productos> consultaProductos(){
        String res = "";
        String URL = "http://localhost:8500/api/productos";
        
        try{
            Client client = ClientBuilder.newClient();
            
            WebTarget target = client.target(URL);

            Invocation.Builder solicitud = target.request();

            Gson gson = new Gson();
            
            Response get = solicitud.get();
            
            String responseJson = get.readEntity(String.class);
                    
            res = responseJson;
            
            Type listType = new TypeToken<List<Productos>>() {}.getType();

            List<Productos> productos = gson.fromJson(res, listType);
            
           
            return productos;
            
        }catch(Exception e){
            System.out.println("error al recibir productos");
            return null;
        }
    }
    
//    public void agregarProducto(Productos producto){
//        String res = "";
//        String URL = "http://localhost:8500/api/productos";
//        
//        try{
//            Client client = ClientBuilder.newClient();
//            
//            WebTarget target = client.target(URL);
//
//            Invocation.Builder solicitud = target.request();
//
//            Gson gson = new Gson();
//            String jsonString = gson.toJson(producto);
//            
//            Response post = solicitud.post(Entity.json(jsonString));
//            
//            String responseJson = post.readEntity(String.class);
//                    
//            System.out.println(responseJson);   
//            
//        }catch(Exception e){
//            System.out.println("error al agregar productos");
//             e.printStackTrace();
//        }
//    }
    
    public List<Comentario> consultaComentario(){
        String res = "";
        String URL = "http://localhost:8087/api/comentarios";
        
        try{
            Client client =ClientBuilder.newClient();
            
            WebTarget target = client.target(URL);

            Invocation.Builder solicitud = target.request();

            Gson gson = new Gson();
            
            Response get = solicitud.get();
            
            String responseJson = get.readEntity(String.class);
                    
            res = responseJson;
            
            Type listType = new TypeToken<List<Comentario>>() {}.getType();

            List<Comentario> comentario = gson.fromJson(res, listType);
            
            return comentario;
            
        }catch(Exception e){
            System.out.println("error al recibir comentarios");
            return null;
        }
    }
    
    public void agregarComentario(Comentario comentario){
        String res = "";
        String URL = "http://localhost:8087/api/comentarios";
        
        try{
            Client client =ClientBuilder.newClient();
            
            WebTarget target = client.target(URL);

            Invocation.Builder solicitud = target.request();

            Gson gson = new Gson();
            String jsonString = gson.toJson(comentario);
            
            Response post = solicitud.post(Entity.json(jsonString));
            
            String responseJson = post.readEntity(String.class);
                    
            System.out.println(responseJson);   
            
        }catch(Exception e){
             e.printStackTrace();
        }
    }
    
}
