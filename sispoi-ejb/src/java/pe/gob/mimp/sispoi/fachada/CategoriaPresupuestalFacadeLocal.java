/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.CategoriaPresupuestal;

/**
 *
 * @author desarrollador
 */
@Local
public interface CategoriaPresupuestalFacadeLocal {

    void create(CategoriaPresupuestal categoriaPresupuestal);

    void edit(CategoriaPresupuestal categoriaPresupuestal);

    void remove(CategoriaPresupuestal categoriaPresupuestal);

    CategoriaPresupuestal find(Object id);

    List<CategoriaPresupuestal> findAll();

    List<CategoriaPresupuestal> findRange(int[] range);

    int count();
    
}
