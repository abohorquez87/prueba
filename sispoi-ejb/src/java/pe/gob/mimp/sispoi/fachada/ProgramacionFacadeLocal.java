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
public interface ProgramacionFacadeLocal {

    void create(Programacion programacion);

    void edit(Programacion programacion);

    void remove(Programacion programacion);

    Programacion find(Object id);

    List<Programacion> findAll();

    List<Programacion> findRange(int[] range);

    int count();
    
    List<Programacion> findAllByField(Object field, Object value);
    
    List<Programacion>  getProgramacionSeguimiento(boolean distinct, EstadoProgramacion estadoProgramacion);
}
