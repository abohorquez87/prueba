/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import pe.gob.mimp.sispoi.modelo.ActividadProgramada;
import pe.gob.mimp.sispoi.modelo.EstadoActProgramada;

/**
 *
 * @author desarrollador
 */
@Stateless
public class ActividadProgramadaFacade extends AbstractFacade<ActividadProgramada> implements ActividadProgramadaFacadeLocal {
    @PersistenceContext(unitName = "sispoi-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadProgramadaFacade() {
        super(ActividadProgramada.class);
    }
    
  
    
}
