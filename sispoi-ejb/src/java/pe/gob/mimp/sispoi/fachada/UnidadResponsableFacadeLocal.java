/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.UnidadResponsable;

/**
 *
 * @author desarrollador
 */
@Local
public interface UnidadResponsableFacadeLocal {

    void create(UnidadResponsable unidadResponsable);

    void edit(UnidadResponsable unidadResponsable);

    void remove(UnidadResponsable unidadResponsable);

    UnidadResponsable find(Object id);

    List<UnidadResponsable> findAll();

    List<UnidadResponsable> findRange(int[] range);

    int count();
    
}
