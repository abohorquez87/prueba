/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.gob.mimp.sispoi.modelo.TipoModificador;

/**
 *
 * @author desarrollador
 */
@Stateless
public class TipoModificadorFacade extends AbstractFacade<TipoModificador> implements TipoModificadorFacadeLocal {
    @PersistenceContext(unitName = "sispoi-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoModificadorFacade() {
        super(TipoModificador.class);
    }
    
}
