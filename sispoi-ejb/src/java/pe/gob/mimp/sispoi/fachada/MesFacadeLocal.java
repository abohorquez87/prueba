/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.Mes;

/**
 *
 * @author desarrollador
 */
@Local
public interface MesFacadeLocal {

    void create(Mes mes);

    void edit(Mes mes);

    void remove(Mes mes);

    Mes find(Object id);

    List<Mes> findAll();

    List<Mes> findRange(int[] range);

    int count();
    
}
