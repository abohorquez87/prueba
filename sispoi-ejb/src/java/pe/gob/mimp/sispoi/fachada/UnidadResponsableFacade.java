/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.gob.mimp.sispoi.modelo.UnidadResponsable;

/**
 *
 * @author desarrollador
 */
@Stateless
public class UnidadResponsableFacade extends AbstractFacade<UnidadResponsable> implements UnidadResponsableFacadeLocal {
    @PersistenceContext(unitName = "sispoi-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnidadResponsableFacade() {
        super(UnidadResponsable.class);
    }
    
}
