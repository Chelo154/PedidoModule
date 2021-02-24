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
public class LineaPedido {
    
    int cantidad;
    
    Producto producto;
    
    double subtotal;
    
    public LineaPedido(int cantidad, Producto producto){
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public double getSubtotal() {
        return subtotal;
    }   
    
    public double calcularSubTotal(){        
        subtotal = producto.precioPorCantidad(cantidad);
        return subtotal;
    }
    
    
    
    
}
