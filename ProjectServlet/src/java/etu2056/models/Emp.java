/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etu2056.models;

<<<<<<< Updated upstream:ProjectServlet/src/java/etu2056/models/Emp.java
import etu2056.AllAnnotations.Method;
=======
import etu2056.AllAnnotations.Url;
import etu2056.framework.servlet.ModelView;
>>>>>>> Stashed changes:TestProject/src/java/modele/Emp.java

/**
 *
 * @author jaona
 */
public class Emp { 
    String name;
    String prenom; 
    
    public Emp(){}
        
<<<<<<< Updated upstream:ProjectServlet/src/java/etu2056/models/Emp.java
     @Method(name_method = "emp-add")
        public void emp_add()
=======
     @Url(name_method = "/emp-add")
        public ModelView findall()
>>>>>>> Stashed changes:TestProject/src/java/modele/Emp.java
        { 
            ModelView mv= new ModelView(); 
            mv.setView("front.jsp");
            return mv;
        } 
        
<<<<<<< Updated upstream:ProjectServlet/src/java/etu2056/models/Emp.java
      @Method(name_method = "emp-all")
         public void emp_all()
=======
      @Url(name_method = "/yay")
         public ModelView emp_all()
>>>>>>> Stashed changes:TestProject/src/java/modele/Emp.java
        { 
            ModelView mv= new ModelView(); 
            mv.setView("front.jsp");
            return mv;
        }
}
    

