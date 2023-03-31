/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etu2056.framework.servlet;

/**
 *
 * @author jaona
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import etu2056.AllAnnotations.Method;
import etu2056.framework.Annotation;
import etu2056.framework.Mapping;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author jaona
 */
public class FrontServlet extends HttpServlet { 
     HashMap<String,Mapping> MappingUrls;

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
        response.setContentType("text/html;charset=UTF-8"); 
       // String [] a = request.getRequestURI().split("/");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet at " + request.getRequestURI() + "</h1>"); 
             
            for ( HashMap.Entry <String, Mapping> en : this.MappingUrls.entrySet()){
            out.println(" Le nom de la classe : "+en.getValue().getClassName());
            out.println(" La methode : "+ en.getValue().getMethod()); 
            }
            out.println("</body>");
            out.println("</html>");
        }
    }  
    
     @Override
    public void init(){
        try{
            Annotation a = new Annotation();
            Vector<Class> vec = a.getClassFrom("etu2056.models");
            for(int i = 0; i < vec.size(); i++) { 
                if(vec.get(i) != null) {
                    insertHashMap(vec.get(i));
                }
            }
            
            afficherHashMap();
        }
        catch(Exception e){
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       }
//       
        public void insertHashMap(Class <?> className) {
         for (java.lang.reflect.Method declaredMethod : className.getDeclaredMethods()) {
           // System.out.println(declaredMethod.getAnnotation(Method.class));
             if (declaredMethod.getAnnotation(Method.class) != null){
                 String url = declaredMethod.getAnnotation(Method.class).name_method();
               //System.out.println(url);
                 this.MappingUrls = new HashMap();
                 Mapping m = new Mapping(className.getSimpleName(), declaredMethod.getName());
                 this.MappingUrls.put(url,m );
                 System.out.println(m.getClassName());
                 System.out.println(m.getMethod());
             }
         }
    }
//       
       public void afficherHashMap(){
           for ( HashMap.Entry<String, Mapping> en : this.MappingUrls.entrySet()) {
            System.out.println(" Le nom de la classe : "+ en.getValue().getClassName());
            System.out.println(" La methode : "+ en.getValue().getMethod()); 
           }
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
            processRequest(request, response); 
        
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
        processRequest(request, response);
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