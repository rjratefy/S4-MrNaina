/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etu2056.models;

import etu2056.AllAnnotations.Method;

/**
 *
 * @author jaona
 */
public class Emp { 
    String name;
    String prenom; 
    
    public Emp(){}
        
     @Method(name_method = "emp-add")
        public void emp_add()
        { 
            System.out.println("emp-add");
        } 
        
      @Method(name_method = "emp-all")
         public void emp_all()
        { 
            System.out.println("emp-all");
        }
}
    

