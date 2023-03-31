/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/ 

package etu2056.framework;

/**
 *
 * @author jaona
 */
public class Mapping { 
    String ClassName;
    String Method; 

    public Mapping(String ClassName, String Method) {
        this.ClassName = ClassName;
        this.Method = Method;
    }
    

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public String getMethod() {
        return Method;
    }

    public void setMethod(String Method) {
        this.Method = Method;
    }
}
