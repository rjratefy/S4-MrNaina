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
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author jaona
 */
public class FrontServlet extends HttpServlet { 
     HashMap<String,Mapping> MappingUrls = new HashMap();
     List<Class> allMethodClass; 

    public HashMap<String, Mapping> getMappingUrls() {
        return MappingUrls;
    }

    public void setMappingUrls(HashMap<String, Mapping> MappingUrls) {
        this.MappingUrls = MappingUrls;
    }

    public List<Class> getAllMethodClass() {
        return allMethodClass;
    }

    public void setAllMethodClass(List<Class> allMethodClass) {
        this.allMethodClass = allMethodClass;
    }
     

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
      public String getUrl(HttpServletRequest request) {
        String result;
        String contextPath = request.getContextPath();
        String url = request.getRequestURI();
        result = url.split(contextPath)[1];
        String query = request.getQueryString();
        return result;
    }
       public Method getMethodFromUrl(String url) throws Exception {
        List<Class> lc = this.getAllMethodClass();
        for (Class c : lc) {
            if (c.getSimpleName().equals(getMappingUrls().get(url).getClassName())) {
                for (Method m : c.getDeclaredMethods()) {
                    if (m.getName().equals(getMappingUrls().get(url).getMethod())){
                        return m;
                    }
                }
            }
        }
        throw new Exception("Method not found"); 
        
    }
           public Class getClassFromUrl(String url) throws Exception {    
        List<Class> lc = this.getAllMethodClass();
        for (Class c : lc) {
            if (c.getSimpleName().equals(getMappingUrls().get(url).getClassName())) {
                for (Method m : c.getDeclaredMethods()) {
                    if (m.getName().equals(getMappingUrls().get(url).getMethod())){
                        return c;
                    }
                }
            }
        }
        throw new Exception("Class not found");
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
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
             Method m = getMethodFromUrl(getUrl(request));   //get the method that correspond to the url key 
            out.println("the method is : "+m.getName());
            Class c = getClassFromUrl(getUrl(request)); //get the class that correspond to the url key 
            out.println("the class is : "+c.getSimpleName());
            Object o = m.invoke(c.newInstance(), null);
            out.println(o);
            if (o instanceof ModelView) {
                ModelView mv = (ModelView)o;
                //HashMap<String,Object> data = mv.();
               // for (Map.Entry<String, Object> entry : data.entrySet()) {
                    //request.setAttribute(entry.getKey(), entry.getValue());
                //}
                RequestDispatcher dispatcher = request.getRequestDispatcher(mv.getView());
                dispatcher.forward(request, response);
            }
        }
    }  
    
     @Override
    public void init(){
        try{
            Annotation a = new Annotation();
            Vector<Class> vec = a.getClassFrom("modele");
            List<Class> l= (List<Class>)vec;
            this.setAllMethodClass(l);
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
         try { 
             processRequest(request, response);
         } catch (Exception ex) {
             Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
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
         try {
             processRequest(request, response);
         } catch (Exception ex) {
             Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
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