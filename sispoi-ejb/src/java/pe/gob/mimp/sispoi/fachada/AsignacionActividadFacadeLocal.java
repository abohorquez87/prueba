/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.AsignacionActividad;

/**
 *
 * @author desarrollador
 */
@Local
public interface AsignacionActividadFacadeLocal {

    void create(AsignacionActividad asignacionActividad);

    void edit(AsignacionActividad asignacionActividad);

    void remove(AsignacionActividad asignacionActividad);

    AsignacionActividad find(Object id);

    List<AsignacionActividad> findAll();

    List<AsignacionActividad> findRange(int[] range);

    int count();
    
}
