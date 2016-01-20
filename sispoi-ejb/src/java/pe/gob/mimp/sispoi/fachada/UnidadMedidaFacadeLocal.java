/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.UnidadMedida;

/**
 *
 * @author desarrollador
 */
@Local
public interface UnidadMedidaFacadeLocal {

    void create(UnidadMedida unidadMedida);

    void edit(UnidadMedida unidadMedida);

    void remove(UnidadMedida unidadMedida);

    UnidadMedida find(Object id);

    List<UnidadMedida> findAll();

    List<UnidadMedida> findRange(int[] range);

    int count();
    
}
