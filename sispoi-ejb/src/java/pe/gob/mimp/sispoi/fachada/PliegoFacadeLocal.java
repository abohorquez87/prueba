/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.Pliego;

/**
 *
 * @author desarrollador
 */
@Local
public interface PliegoFacadeLocal {

    void create(Pliego pliego);

    void edit(Pliego pliego);

    void remove(Pliego pliego);

    Pliego find(Object id);

    List<Pliego> findAll();

    List<Pliego> findRange(int[] range);

    int count();
    
}
