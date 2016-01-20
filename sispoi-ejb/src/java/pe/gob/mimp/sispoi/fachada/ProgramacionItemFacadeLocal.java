/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.ProgramacionItem;

/**
 *
 * @author desarrollador
 */
@Local
public interface ProgramacionItemFacadeLocal {

    void create(ProgramacionItem programacionItem);

    void edit(ProgramacionItem programacionItem);

    void remove(ProgramacionItem programacionItem);

    ProgramacionItem find(Object id);

    List<ProgramacionItem> findAll();

    List<ProgramacionItem> findRange(int[] range);

    int count();
    
}
