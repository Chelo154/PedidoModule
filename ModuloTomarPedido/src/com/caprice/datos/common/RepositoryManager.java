/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caprice.datos.common;

import com.caprice.datos.adapter.MesaArrayListAdapter;
import com.caprice.datos.adapter.PedidoArrayListAdapter;
import com.caprice.datos.adapter.ProductArrayListAdapter;
import com.caprice.dominio.Mesa;
import com.caprice.dominio.Pedido;
import com.caprice.dominio.Producto;

/**
 *
 * @author chelo
 */
public class RepositoryManager {
    
    private IRepository<Pedido> repoPedidos;
    private IRepository<Producto> repoProductos;
    private IRepository<Mesa> repoMesas;
    
    private static RepositoryManager manager;
    
    public RepositoryManager(){
        initConfig();
    }
    
    public static RepositoryManager getManager(){
        if(manager == null){
            manager = new RepositoryManager();
        }
        return manager;
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
    
    
    private void initConfig(){
        this.repoPedidos = new PedidoArrayListAdapter();
        this.repoProductos = new ProductArrayListAdapter();
        this.repoMesas = new MesaArrayListAdapter();
    }
    
    
    private void seedProducts(){
        this.repoProductos.guardar(new Producto(1,"Papas",150));
        this.repoProductos.guardar(new Producto(2,"Pizza Caprice",250));
        this.repoProductos.guardar(new Producto(1,"Honey Beer",300));
    }
    
    private void seedMesas(){
        this.repoMesas.guardar(new Mesa(1, 2));
        this.repoMesas.guardar(new Mesa(2, 4));
        this.repoMesas.guardar(new Mesa(3, 2));
    }
    
}
