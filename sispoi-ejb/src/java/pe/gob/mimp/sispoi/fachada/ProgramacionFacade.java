/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import pe.gob.mimp.sispoi.modelo.AtencionProgramacion;
import pe.gob.mimp.sispoi.modelo.AtencionProgramacion_;
import pe.gob.mimp.sispoi.modelo.EstadoProgramacion;
import pe.gob.mimp.sispoi.modelo.Programacion;
import pe.gob.mimp.sispoi.modelo.Programacion_;

/**
 *
 * @author desarrollador
 */
@Stateless
public class ProgramacionFacade extends AbstractFacade<Programacion> implements ProgramacionFacadeLocal {
    @PersistenceContext(unitName = "sispoi-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProgramacionFacade() {
        super(Programacion.class);
    }
    
    public List<Programacion>  getProgramacionSeguimiento(boolean distinct, EstadoProgramacion estadoProgramacion) 
    {
        System.out.println("00---------------------------------------------------------------------------00");
    	
        CriteriaQuery<Programacion> cq = getEntityManager().getCriteriaBuilder().createQuery(Programacion.class);

        Root<Programacion> registro = cq.from(Programacion.class);
        
        Join<Programacion, AtencionProgramacion> join = registro.join(Programacion_.atencionProgramacionList);
        
        if (distinct) cq.distinct(true);
        
        cq.where(
                getEntityManager().getCriteriaBuilder().and(
                        getEntityManager().getCriteriaBuilder().equal(registro.get(Programacion_.flgActivo), BigInteger.ONE)
                        ,getEntityManager().getCriteriaBuilder().equal(join.get(AtencionProgramacion_.estadoProgramacion), estadoProgramacion)
                ));
        
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        
        return q.getResultList();
    }
}
