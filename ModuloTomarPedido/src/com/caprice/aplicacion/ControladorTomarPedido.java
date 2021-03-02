/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caprice.aplicacion;

import com.caprice.datos.common.IRepository;
import com.caprice.datos.common.RepositoryManager;
import com.caprice.dominio.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chelo
 */
public class ControladorTomarPedido {
            
    private RepositoryManager manager;
    Pedido nuevoPedido;
    
   
   public ControladorTomarPedido(RepositoryManager manager){
       
        this.manager = manager; 
              
   }

    public Pedido getNuevoPedido() {
        return nuevoPedido;
    }      
   
   public void iniciarPedido(int legajo){
       
       Mozo mozo = manager.getRepoMozos().buscarPorID(legajo);
       int numero = manager.getRepoPedidos().size() + 1;
       nuevoPedido = new Pedido(numero,0, mozo);
      
   }
   
   public List<Mesa> getMesasLibres(){
       return manager.getRepoMesas().where(mesa -> mesa.getEstado() == EstadoMesa.LIBRE);
   }
   
   public void setMesa(int codigoMesa){
        
       Mesa mesa = manager.getRepoMesas().buscarPorID(codigoMesa);
        
        nuevoPedido.setMesas(mesa);
   }
   
   public void agregarProducto(int codigoProducto, int cantidad){
       
       Producto producto = manager.getRepoProductos().buscarPorID(codigoProducto);
       
       nuevoPedido.agregarLinea(producto, cantidad);
   }   
   
   public void confirmarPedido(){
       nuevoPedido.getMesaPrincipal().ocupar();
       manager.getRepoPedidos().guardar(nuevoPedido);
   }
   
   
   
       
}
