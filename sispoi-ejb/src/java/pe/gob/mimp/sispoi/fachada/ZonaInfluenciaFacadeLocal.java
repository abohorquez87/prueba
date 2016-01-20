/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.ZonaInfluencia;

/**
 *
 * @author desarrollador
 */
@Local
public interface ZonaInfluenciaFacadeLocal {

    void create(ZonaInfluencia zonaInfluencia);

    void edit(ZonaInfluencia zonaInfluencia);

    void remove(ZonaInfluencia zonaInfluencia);

    ZonaInfluencia find(Object id);

    List<ZonaInfluencia> findAll();

    List<ZonaInfluencia> findRange(int[] range);

    int count();
    
}
