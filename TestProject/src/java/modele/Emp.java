/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import etu2056.AllAnnotations.Url;

/**
 *
 * @author jaona
 */
public class Emp { 
    String name;
    String prenom; 
    
    public Emp(){}
        
     @Url(name_method = "emp-add")
        public void emp_add()
        { 
            System.out.println("emp-add");
        } 
        
      @Url(name_method = "emp-all")
         public void emp_all()
        { 
            System.out.println("emp-all");
        }
}
    

