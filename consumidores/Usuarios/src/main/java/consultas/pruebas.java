/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package consultas;

import entidades.Comentario;
import entidades.Productos;
import java.util.List;

/**
 *
 * @author rjsaa
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Consultas consultas = new Consultas();
        //consulta productos
        List<Productos> productos =consultas.consultaProductos();
        
        for (Productos x:productos){
            System.out.println(x);
        }
        
        //añade un comentario
//        Comentario comentario = new Comentario();
//       
//        comentario.setId_producto("");
//        comentario.setComentario("no me gusto");
//        comentario.setCalificacion(1);
//        
//        consultas.agregarComentario(comentario);
        
    }
    
}
