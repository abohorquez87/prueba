/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.AccionEstrategica;

/**
 *
 * @author desarrollador
 */
@Local
public interface AccionEstrategicaFacadeLocal {

    void create(AccionEstrategica accionEstrategica);

    void edit(AccionEstrategica accionEstrategica);

    void remove(AccionEstrategica accionEstrategica);

    AccionEstrategica find(Object id);

    List<AccionEstrategica> findAll();

    List<AccionEstrategica> findRange(int[] range);

    int count();
    
}
