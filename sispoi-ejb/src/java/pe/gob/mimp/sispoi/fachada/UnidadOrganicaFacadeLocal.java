/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.UnidadOrganica;

/**
 *
 * @author desarrollador
 */
@Local
public interface UnidadOrganicaFacadeLocal {

    void create(UnidadOrganica unidadOrganica);

    void edit(UnidadOrganica unidadOrganica);

    void remove(UnidadOrganica unidadOrganica);

    UnidadOrganica find(Object id);

    List<UnidadOrganica> findAll();

    List<UnidadOrganica> findRange(int[] range);

    int count();
    
}
