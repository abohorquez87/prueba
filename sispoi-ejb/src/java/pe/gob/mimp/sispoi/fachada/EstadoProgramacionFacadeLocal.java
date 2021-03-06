/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.EstadoProgramacion;
import pe.gob.mimp.sispoi.modelo.Programacion;

/**
 *
 * @author desarrollador
 */
@Local
public interface EstadoProgramacionFacadeLocal {

    void create(EstadoProgramacion estadoProgramacion);

    void edit(EstadoProgramacion estadoProgramacion);

    void remove(EstadoProgramacion estadoProgramacion);

    EstadoProgramacion find(Object id);

    List<EstadoProgramacion> findAll();

    List<EstadoProgramacion> findRange(int[] range);

    int count();
    
    List<EstadoProgramacion> findAllByField(Object field, Object value);
    
}
