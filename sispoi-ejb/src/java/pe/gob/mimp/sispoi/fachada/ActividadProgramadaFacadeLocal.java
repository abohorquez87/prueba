/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.ActividadProgramada;

/**
 *
 * @author desarrollador
 */
@Local
public interface ActividadProgramadaFacadeLocal {

    void create(ActividadProgramada actividadProgramada);

    void edit(ActividadProgramada actividadProgramada);

    void remove(ActividadProgramada actividadProgramada);

    ActividadProgramada find(Object id);

    List<ActividadProgramada> findAll();

    List<ActividadProgramada> findRange(int[] range);

    int count();
    
}
