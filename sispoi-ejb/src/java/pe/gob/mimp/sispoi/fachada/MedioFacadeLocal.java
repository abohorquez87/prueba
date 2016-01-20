/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.Medio;

/**
 *
 * @author desarrollador
 */
@Local
public interface MedioFacadeLocal {

    void create(Medio medio);

    void edit(Medio medio);

    void remove(Medio medio);

    Medio find(Object id);

    List<Medio> findAll();

    List<Medio> findRange(int[] range);

    int count();
    
}
