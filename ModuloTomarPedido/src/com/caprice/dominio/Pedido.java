/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caprice.dominio;

import java.util.ArrayList;

/**
 *
 * @author chelo
 */
public class Pedido {
    
    int numero;
    int tiempoEspera;
    double total;  
    Mozo mozo;
    ArrayList<LineaPedido> lineas;
    ArrayList<Mesa> mesas;
    
    /*-------------Constructor--------------------*/
    
    public Pedido(int numero, int tiempoEspera,Mozo mozo){
       this.numero = numero;
       this.tiempoEspera = tiempoEspera;
       this.mozo = mozo;
       this.lineas = new ArrayList<>();
       this.calcularTotal();
    }
    
    /*-------------Getter/Setter--------------------*/


    public int getNumero() {
        return numero;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public ArrayList<LineaPedido> getLineas() {
        return lineas;
    } 
    
    public void setMesas(Mesa mesa){
        mesa.ocupar();
        this.mesas = mesa.getAllMesas();
    }

    public double getTotal() {
        return total;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }  
    
    public Mesa getMesaPrincipal(){
        return mesas.get(0);
    }
    
   /*-------------Metodos--------------------*/
    
    
    public void agregarLinea(Producto producto, int cantidad){        
        lineas.add(new LineaPedido(cantidad, producto));
        calcularTotal();
    }
    
    public void calcularTotal()
    {
        double importe = 0;
        
        for(LineaPedido p : lineas )
        {
            importe += p.calcularSubTotal();            
        }        
        total = importe;
    }
    
}
