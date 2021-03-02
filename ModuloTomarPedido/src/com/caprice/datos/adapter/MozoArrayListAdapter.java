/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caprice.datos.adapter;

import com.caprice.datos.common.IRepository;
import com.caprice.dominio.Mozo;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author chelo
 */
public class MozoArrayListAdapter implements IRepository<Mozo> {

    ArrayList<Mozo> mozos;
    
    public MozoArrayListAdapter(){
        this.mozos = new ArrayList<>();
    }
    @Override
    public void guardar(Mozo objeto) {
        mozos.add(objeto);
    }

    @Override
    public List<Mozo> obtener() {
        return mozos;
    }

    @Override
    public Mozo buscarPorID(int id) {
        
        for(Mozo m : mozos)
        {
            if(m.getLegajo() == id) return m;
        }
        return null;
    }

    @Override
    public void Eliminar(int id) {
        Mozo eliminar = buscarPorID(id);
        mozos.remove(eliminar);
    }

    @Override
    public void Modificar(int id, Mozo entidadModificada) {
        
        for (Mozo m : mozos){
            if(m.getLegajo() == id){
                m = entidadModificada;
                break;
            }
        }
    }

    @Override
    public int size() {
        return mozos.size();
    }

    @Override
    public List<Mozo> where(Predicate<Mozo> predicado) {
        
        ArrayList<Mozo> matches = new ArrayList<>();
        
        for(Mozo m : mozos){
            if(predicado.test(m)){
                matches.add(m);
            }
        }
        return matches;
        
    }
    
}
