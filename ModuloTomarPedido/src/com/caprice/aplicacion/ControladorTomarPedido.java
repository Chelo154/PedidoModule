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
    
    private IRepository<Producto> repoProductos;
    private IRepository<Pedido> repoPedidos; 
    private IRepository<Mesa> repoMesas;
    Pedido nuevoPedido;
    
   
   public ControladorTomarPedido(RepositoryManager manager){
       
        this.repoProductos = manager.getRepoProductos();
        this.repoPedidos = manager.getRepoPedidos();
        this.repoMesas = manager.getRepoMesas();
   }

    public Pedido getNuevoPedido() {
        return nuevoPedido;
    }      
   
   public void iniciarPedido(){
       
       int numero = repoPedidos.size() + 1;
       nuevoPedido = new Pedido(numero,0);
      
   }
   
   public List<Mesa> getMesasLibres(){
       return repoMesas.where(mesa -> mesa.getEstado() == EstadoMesa.LIBRE);
   }
   
   public void setMesa(int codigoMesa){
        
       Mesa mesa = repoMesas.buscarPorID(codigoMesa);
        
        nuevoPedido.setMesas(mesa);
   }
   
   public void agregarProducto(int codigoProducto, int cantidad){
       
       Producto producto = repoProductos.buscarPorID(codigoProducto);
       
       nuevoPedido.agregarLinea(producto, cantidad);
   }   
   
   public void confirmarPedido(){
       nuevoPedido.getMesaPrincipal().ocupar();
       repoPedidos.guardar(nuevoPedido);
   }
   
   
   
       
}
