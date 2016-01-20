/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.DivisionFuncional;

/**
 *
 * @author desarrollador
 */
@Local
public interface DivisionFuncionalFacadeLocal {

    void create(DivisionFuncional divisionFuncional);

    void edit(DivisionFuncional divisionFuncional);

    void remove(DivisionFuncional divisionFuncional);

    DivisionFuncional find(Object id);

    List<DivisionFuncional> findAll();

    List<DivisionFuncional> findRange(int[] range);

    int count();
    
}
