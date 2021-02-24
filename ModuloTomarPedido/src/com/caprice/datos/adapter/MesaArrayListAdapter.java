/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caprice.datos.adapter;

import com.caprice.datos.common.IRepository;
import com.caprice.dominio.Mesa;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author chelo
 */
public class MesaArrayListAdapter implements IRepository<Mesa>{

    private ArrayList<Mesa> mesas;
    
    public MesaArrayListAdapter(){
        this.mesas = new ArrayList<>();
    }
    
    @Override
    public void guardar(Mesa objeto) {
        mesas.add(objeto);
    }

    @Override
    public List<Mesa> obtener() {
        return mesas;
    }

    @Override
    public Mesa buscarPorID(int id) {
       
        for(Mesa m : mesas){
           if(m.getNumero() == id){
               return m;
           }
       }
       return null;
    }

    @Override
    public void Eliminar(int id) {
        Mesa eliminar = buscarPorID(id);
        mesas.remove(eliminar);
    }

    @Override
    public void Modificar(int id, Mesa entidadModificada) {
        
        for(Mesa m : mesas){
            if(m.getNumero() == id){
                m = entidadModificada;
                break;
            }
        }
        
    }

    @Override
    public int size() {
        return mesas.size();
    }

    @Override
    public List<Mesa> where(Predicate<Mesa> predicado) {        
        
        ArrayList<Mesa> matches = new ArrayList<>();
        
        
        for(Mesa m : mesas){
            if(predicado.test(m)){
                matches.add(m);
            }
        }
        
        return matches;
    }
    
}
