/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caprice.datos.adapter;

import com.caprice.datos.common.IRepository;
import com.caprice.dominio.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chelo
 */
public class ProductArrayListAdapter implements IRepository<Producto>{

    ArrayList<Producto> productos;
    
    public ProductArrayListAdapter(){
        this.productos = new ArrayList<>();
    }
    @Override
    public void guardar(Producto objeto) {
        productos.add(objeto);
    }

    @Override
    public List<Producto> obtener() {
        return productos;
    }

    @Override
    public Producto buscarPorID(int id) {
        for (Producto p : productos){
            if(p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public void Eliminar(int id) {
        Producto eliminar = buscarPorID(id);
        productos.remove(eliminar);
    }

    @Override
    public void Modificar(int id, Producto entidadModificada) {
        for (Producto p : productos){
            if(p.getId() == id) {
                p = entidadModificada;
                break;
            }
        }
    }
    
    
}
