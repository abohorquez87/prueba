/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.TipoObjetivoEstrategico;

/**
 *
 * @author desarrollador
 */
@Local
public interface TipoObjetivoEstrategicoFacadeLocal {

    void create(TipoObjetivoEstrategico tipoObjetivoEstrategico);

    void edit(TipoObjetivoEstrategico tipoObjetivoEstrategico);

    void remove(TipoObjetivoEstrategico tipoObjetivoEstrategico);

    TipoObjetivoEstrategico find(Object id);

    List<TipoObjetivoEstrategico> findAll();

    List<TipoObjetivoEstrategico> findRange(int[] range);

    int count();
    
}
