/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caprice.datos.adapter;

import com.caprice.datos.common.IRepository;
import com.caprice.dominio.Pedido;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author chelo
 */
public class PedidoArrayListAdapter implements IRepository<Pedido>{

    ArrayList<Pedido> pedidos;
    
    public PedidoArrayListAdapter(){
        this.pedidos = new ArrayList<>();
    }
    @Override
    public void guardar(Pedido objeto) {
        pedidos.add(objeto);
    }

    @Override
    public List<Pedido> obtener() {
       return pedidos;
    }

    @Override
    public Pedido buscarPorID(int id) {
        for(Pedido p : pedidos){
            if(p.getNumero() == id) return p;
        }
        return null;
    }

    @Override
    public void Eliminar(int id) {
        Pedido pedidoAElminar = buscarPorID(id);
        
        pedidos.remove(pedidoAElminar);
    }

    @Override
    public void Modificar(int id, Pedido entidadModificada) {
        
        for(Pedido p : pedidos){
            if(p.getNumero() == id){
                p = entidadModificada;
                break;
            }        
        }
        
    }

    @Override
    public int size() {
        return pedidos.size();
    }

    @Override
    public List<Pedido> where(Predicate<Pedido> predicado) {
        ArrayList<Pedido> matches = new ArrayList<>();
        
        for(Pedido p : pedidos){
            if(predicado.test(p)){
                matches.add(p);
            }
        }
        
        return matches;
    }
    
    
}
