package au.com.healthsutra.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public abstract class AbstractDAO {

    @PersistenceContext
    private EntityManager em;

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    protected EntityManager getEntityManager() {
        return em;
    }

    @Transactional
    public void persist(Object entity) {
        em.persist(entity);
    }

    @Transactional
    public void persist() {
        this.em.persist(this);
    }

    @Transactional
    public void remove() {
        this.em.remove(this);
    }

    @Transactional
    public void flush() {
        this.em.flush();
    }

    @Transactional
    public void clear() {
        this.em.clear();
    }

    @Transactional
    public void merge() {
        em.merge(this);
    }
}