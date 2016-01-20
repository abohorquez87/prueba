/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.gob.mimp.sispoi.modelo.EstadoProgramacion;

/**
 *
 * @author desarrollador
 */
@Stateless
public class EstadoProgramacionFacade extends AbstractFacade<EstadoProgramacion> implements EstadoProgramacionFacadeLocal {
    @PersistenceContext(unitName = "sispoi-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoProgramacionFacade() {
        super(EstadoProgramacion.class);
    }
    
}
