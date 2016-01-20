/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.Periodo;

/**
 *
 * @author desarrollador
 */
@Local
public interface PeriodoFacadeLocal {

    void create(Periodo periodo);

    void edit(Periodo periodo);

    void remove(Periodo periodo);

    Periodo find(Object id);

    List<Periodo> findAll();

    List<Periodo> findRange(int[] range);

    int count();
    
}
