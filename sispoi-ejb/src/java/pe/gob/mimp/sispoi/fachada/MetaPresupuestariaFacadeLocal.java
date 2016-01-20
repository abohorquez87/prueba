/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.MetaPresupuestaria;

/**
 *
 * @author desarrollador
 */
@Local
public interface MetaPresupuestariaFacadeLocal {

    void create(MetaPresupuestaria metaPresupuestaria);

    void edit(MetaPresupuestaria metaPresupuestaria);

    void remove(MetaPresupuestaria metaPresupuestaria);

    MetaPresupuestaria find(Object id);

    List<MetaPresupuestaria> findAll();

    List<MetaPresupuestaria> findRange(int[] range);

    int count();
    
}
