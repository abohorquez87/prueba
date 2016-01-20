/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.GrupoFuncional;

/**
 *
 * @author desarrollador
 */
@Local
public interface GrupoFuncionalFacadeLocal {

    void create(GrupoFuncional grupoFuncional);

    void edit(GrupoFuncional grupoFuncional);

    void remove(GrupoFuncional grupoFuncional);

    GrupoFuncional find(Object id);

    List<GrupoFuncional> findAll();

    List<GrupoFuncional> findRange(int[] range);

    int count();
    
}
