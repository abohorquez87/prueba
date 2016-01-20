/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.TipoModificador;

/**
 *
 * @author desarrollador
 */
@Local
public interface TipoModificadorFacadeLocal {

    void create(TipoModificador tipoModificador);

    void edit(TipoModificador tipoModificador);

    void remove(TipoModificador tipoModificador);

    TipoModificador find(Object id);

    List<TipoModificador> findAll();

    List<TipoModificador> findRange(int[] range);

    int count();
    
}
