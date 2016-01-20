/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.AtencionProgramacion;

/**
 *
 * @author desarrollador
 */
@Local
public interface AtencionProgramacionFacadeLocal {

    void create(AtencionProgramacion atencionProgramacion);

    void edit(AtencionProgramacion atencionProgramacion);

    void remove(AtencionProgramacion atencionProgramacion);

    AtencionProgramacion find(Object id);

    List<AtencionProgramacion> findAll();

    List<AtencionProgramacion> findRange(int[] range);

    int count();
    
}
