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
        //añade un producto
        Productos producto = new Productos();
        List<Productos> productos = consultas.consultaProductos();
//        producto.setId((productos.size()+1)+"");
//        producto.setDescripcion("Es un libro");
//        producto.setNombre("cuaderno");

        //consultas.agregarProducto(producto);
        //consulta productos
        productos = consultas.consultaProductos();
        if (productos != null) {
            for (Productos x : productos) {
                System.out.println(x);
            }

        } else {
            System.out.println("La lista de productos es nula");
        }

        //añade un comentario
        Comentario comentario = new Comentario();
       
        comentario.setId_producto("");
        comentario.setComentario("no me gusto");
        comentario.setCalificacion(1);
        
        consultas.agregarComentario(comentario);
        
        List<Comentario> comentarioList =consultas.consultaComentario();
        for (Comentario x:comentarioList){
            System.out.println(x);
        }
    }

}
