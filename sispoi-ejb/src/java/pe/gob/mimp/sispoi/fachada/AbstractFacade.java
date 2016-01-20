/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.fachada;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import pe.gob.mimp.sispoi.util.Parametro;

/**
 *
 * @author desarrollador
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    public List<T> findAllByField(Object field, Object value) {
    	CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<T> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
        Root<T> entitie = criteriaQuery.from(entityClass);
        
        criteriaQuery.select(entitie).where(criteriaBuilder.equal(entitie.get(field.toString()), value));             
        
        System.out.println("criterio de busqueda: campo: " + field.toString() + " valor: " + value.toString());
        
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }
    
    public List<T> obtenerPorParametros(Object parametrosRecibidos) 
	{
    	javax.persistence.criteria.CriteriaQuery<T> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
    	ArrayList<ArrayList<String>> parametros = ((Parametro)parametrosRecibidos).getParametros();
       	CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
       	List<Predicate> predicados = new ArrayList<Predicate>();
        Root<T> entitie = criteriaQuery.from(entityClass);
        
        for(int i = 0; i < parametros.size(); i++)
        {
        	predicados.add(criteriaBuilder.equal(entitie.get(parametros.get(i).get(0)), parametros.get(i).get(1)));
        }
        
        criteriaQuery.select(entitie).where(predicados.toArray(new Predicate[]{}));             
        
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }
    
    
}
