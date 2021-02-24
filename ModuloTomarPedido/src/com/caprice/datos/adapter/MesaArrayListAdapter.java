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
        
    }

    @Override
    public List<Mesa> obtener() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mesa buscarPorID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificar(int id, Mesa entidadModificada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
