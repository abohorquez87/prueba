/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.TipoActividadProgramada;

/**
 *
 * @author desarrollador
 */
@Local
public interface TipoActividadProgramadaFacadeLocal {

    void create(TipoActividadProgramada tipoActividadProgramada);

    void edit(TipoActividadProgramada tipoActividadProgramada);

    void remove(TipoActividadProgramada tipoActividadProgramada);

    TipoActividadProgramada find(Object id);

    List<TipoActividadProgramada> findAll();

    List<TipoActividadProgramada> findRange(int[] range);

    int count();
    
}
