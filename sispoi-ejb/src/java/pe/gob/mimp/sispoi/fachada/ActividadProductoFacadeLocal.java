/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.ActividadProducto;

/**
 *
 * @author desarrollador
 */
@Local
public interface ActividadProductoFacadeLocal {

    void create(ActividadProducto actividadProducto);

    void edit(ActividadProducto actividadProducto);

    void remove(ActividadProducto actividadProducto);

    ActividadProducto find(Object id);

    List<ActividadProducto> findAll();

    List<ActividadProducto> findRange(int[] range);

    int count();
    
}
