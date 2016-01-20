/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.Provincia;

/**
 *
 * @author desarrollador
 */
@Local
public interface ProvinciaFacadeLocal {

    void create(Provincia provincia);

    void edit(Provincia provincia);

    void remove(Provincia provincia);

    Provincia find(Object id);

    List<Provincia> findAll();

    List<Provincia> findRange(int[] range);

    int count();
    
}
