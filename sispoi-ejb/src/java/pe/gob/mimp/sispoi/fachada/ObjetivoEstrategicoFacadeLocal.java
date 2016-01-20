/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.ObjetivoEstrategico;

/**
 *
 * @author desarrollador
 */
@Local
public interface ObjetivoEstrategicoFacadeLocal {

    void create(ObjetivoEstrategico objetivoEstrategico);

    void edit(ObjetivoEstrategico objetivoEstrategico);

    void remove(ObjetivoEstrategico objetivoEstrategico);

    ObjetivoEstrategico find(Object id);

    List<ObjetivoEstrategico> findAll();

    List<ObjetivoEstrategico> findRange(int[] range);

    int count();
    
}
