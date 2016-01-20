/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Local;
import pe.gob.mimp.sispoi.modelo.Verificacion;

/**
 *
 * @author desarrollador
 */
@Local
public interface VerificacionFacadeLocal {

    void create(Verificacion verificacion);

    void edit(Verificacion verificacion);

    void remove(Verificacion verificacion);

    Verificacion find(Object id);

    List<Verificacion> findAll();

    List<Verificacion> findRange(int[] range);

    int count();
    
}
