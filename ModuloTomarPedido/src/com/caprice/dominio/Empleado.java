/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caprice.dominio;

/**
 *
 * @author chelo
 */
public class Empleado {
    
    int legajo;
    int nombre;
    
    public Empleado(int legajo, int nombre){
        this.legajo = legajo;
        this.nombre = nombre;
    } 

    public int getLegajo() {
        return legajo;
    }

    public int getNombre() {
        return nombre;
    }  
    
    
    
}
