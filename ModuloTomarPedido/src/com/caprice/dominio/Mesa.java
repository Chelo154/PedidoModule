/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caprice.dominio;

import java.util.ArrayList;

/**
 *
 * @author chelo
 */
public class Mesa {
    
    int numero;
    int cantidadComensales;
    EstadoMesa estado;
    
    ArrayList<Mesa> mesasCombinadas = new ArrayList<>();
    
    public Mesa(int numero, int cantidadComensales){
        this.numero = numero;
        this.cantidadComensales = cantidadComensales;
        mesasCombinadas = new ArrayList<>();   
        this.estado = EstadoMesa.LIBRE;
    }

    public int getNumero() {
        return numero;
    }

    public int getCantidadComensales() {
        return cantidadComensales;
    }

    public ArrayList<Mesa> getMesasCombinadas() {
        return mesasCombinadas;
    }

    public EstadoMesa getEstado() {
        return estado;
    }   
    
    public void combinar(Mesa mesa){
        mesa.combinado();
        mesasCombinadas.add(mesa);
    }
    
    public void combinado(){
        this.estado = EstadoMesa.COMBINADO;
    }
    
    public void liberar(){
        this.estado = EstadoMesa.LIBRE;
    }
    
    public void ocupar(){
        this.estado = EstadoMesa.OCUPADO;
    }
    
    public ArrayList<Mesa> getAllMesas()
    {
        ArrayList<Mesa> fullMesa = new ArrayList<>();
        fullMesa.add(this);
        fullMesa.addAll(this.mesasCombinadas);        
        return fullMesa;
    }
    
}
