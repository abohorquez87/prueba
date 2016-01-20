/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.gob.mimp.sispoi.modelo.ProgramacionItem;

/**
 *
 * @author desarrollador
 */
@Stateless
public class ProgramacionItemFacade extends AbstractFacade<ProgramacionItem> implements ProgramacionItemFacadeLocal {
    @PersistenceContext(unitName = "sispoi-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProgramacionItemFacade() {
        super(ProgramacionItem.class);
    }
    
}
