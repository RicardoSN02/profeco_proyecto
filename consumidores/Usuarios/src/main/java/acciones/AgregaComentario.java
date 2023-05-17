/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package acciones;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import consultas.Consultas;
import entidades.Comentario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexandra
 */
@WebServlet(name = "AgregaComentario", urlPatterns = {"/AgregaComentario"})
public class AgregaComentario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          //      processRequest(request, response);
            Gson gson = new Gson();
            List<Comentario> lista = null;
            
            
            response.setContentType("application/json");
            String isbn = request.getParameter("isbn");
            String titulo = request.getParameter("titulo");
            String editorial = request.getParameter("editorial");
            String clasificacion= request.getParameter("clasificacion");
            String periodicidad = request.getParameter("periodicidad");
            String fecha= request.getParameter("fecha");
            
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-dd-MM");
         
            String listaJson = null;
            // Crea el objeto para acceder a la base de datos
            
            Comentario revista  = new Comentario();
            revista.setId(isbn);
            revista.setId_producto(titulo);
            revista.setComentario(editorial);
            revista.setCalificacion(1);
        
            Consultas con = new Consultas();
        
            con.agregarComentario(revista);
            try (PrintWriter out = response.getWriter()) {
                out.println(listaJson);   
                out.flush();
            }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
