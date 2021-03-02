/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caprice.datos.common;

import com.caprice.datos.adapter.MesaArrayListAdapter;
import com.caprice.datos.adapter.MozoArrayListAdapter;
import com.caprice.datos.adapter.PedidoArrayListAdapter;
import com.caprice.datos.adapter.ProductArrayListAdapter;
import com.caprice.dominio.Mesa;
import com.caprice.dominio.Mozo;
import com.caprice.dominio.Pedido;
import com.caprice.dominio.Producto;

/**
 *
 * @author chelo
 */
public class RepositoryManager {
    
    private  IRepository<Pedido> repoPedidos;
    private  IRepository<Producto> repoProductos;
    private  IRepository<Mesa> repoMesas;
    private  IRepository<Mozo> mozos;
    
    private   RepositoryManager manager;    
    
    
    public RepositoryManager()
    {
        this.repoPedidos = new PedidoArrayListAdapter();
        this.repoProductos = new ProductArrayListAdapter();
        this.repoMesas = new MesaArrayListAdapter();
        this.mozos = new MozoArrayListAdapter();
    }  
    

    public IRepository<Pedido> getRepoPedidos() {
        return repoPedidos;
    }

    public IRepository<Producto> getRepoProductos() {
        return repoProductos;
    }     

    public IRepository<Mesa> getRepoMesas() {
        return repoMesas;
    }   
    
    public void seedData(){
        seedProducts();
        seedMesas();
    }   
    
    private void seedProducts(){
       repoProductos.guardar(new Producto(1,"Papas",150));
       repoProductos.guardar(new Producto(2,"Pizza Caprice",250));
       repoProductos.guardar(new Producto(1,"Honey Beer",300));
    }
    
    private void seedMesas(){
        repoMesas.guardar(new Mesa(1, 2));
        repoMesas.guardar(new Mesa(2, 4));
        repoMesas.guardar(new Mesa(3, 2));
    }
    
}
