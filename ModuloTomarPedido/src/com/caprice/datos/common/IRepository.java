/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caprice.datos.common;

import java.util.List;

/**
 *
 * @author chelo
 */
public interface IRepository<Entity> {
    
    public void guardar(Entity objeto);
    public List<Entity> obtener();
    public Entity buscarPorID(int id);
    public void Eliminar(int id);
    public void Modificar(int id, Entity entidadModificada);
    
}
