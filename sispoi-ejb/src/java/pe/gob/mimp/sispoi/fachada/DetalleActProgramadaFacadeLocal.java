/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.DetalleActProgramada;

/**
 *
 * @author desarrollador
 */
@Local
public interface DetalleActProgramadaFacadeLocal {

    void create(DetalleActProgramada detalleActProgramada);

    void edit(DetalleActProgramada detalleActProgramada);

    void remove(DetalleActProgramada detalleActProgramada);

    DetalleActProgramada find(Object id);

    List<DetalleActProgramada> findAll();

    List<DetalleActProgramada> findRange(int[] range);

    int count();
    
}
