/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.UnidadEjecutora;

/**
 *
 * @author desarrollador
 */
@Local
public interface UnidadEjecutoraFacadeLocal {

    void create(UnidadEjecutora unidadEjecutora);

    void edit(UnidadEjecutora unidadEjecutora);

    void remove(UnidadEjecutora unidadEjecutora);

    UnidadEjecutora find(Object id);

    List<UnidadEjecutora> findAll();

    List<UnidadEjecutora> findRange(int[] range);

    int count();
    
}
