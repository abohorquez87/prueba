/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.gob.mimp.sispoi.modelo.DivisionFuncional;

/**
 *
 * @author desarrollador
 */
@Stateless
public class DivisionFuncionalFacade extends AbstractFacade<DivisionFuncional> implements DivisionFuncionalFacadeLocal {
    @PersistenceContext(unitName = "sispoi-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DivisionFuncionalFacade() {
        super(DivisionFuncional.class);
    }
    
}
