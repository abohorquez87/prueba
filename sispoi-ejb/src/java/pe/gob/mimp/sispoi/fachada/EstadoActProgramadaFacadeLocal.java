/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.EstadoActProgramada;

/**
 *
 * @author desarrollador
 */
@Local
public interface EstadoActProgramadaFacadeLocal {

    void create(EstadoActProgramada estadoActProgramada);

    void edit(EstadoActProgramada estadoActProgramada);

    void remove(EstadoActProgramada estadoActProgramada);

    EstadoActProgramada find(Object id);

    List<EstadoActProgramada> findAll();

    List<EstadoActProgramada> findRange(int[] range);

    int count();
    
}
