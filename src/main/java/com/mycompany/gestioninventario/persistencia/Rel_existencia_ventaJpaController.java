/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventario.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.gestioninventario.logica.Venta;
import com.mycompany.gestioninventario.logica.Existencia;
import com.mycompany.gestioninventario.logica.Rel_existencia_venta;
import com.mycompany.gestioninventario.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author imlevan
 */
public class Rel_existencia_ventaJpaController implements Serializable {

    public Rel_existencia_ventaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public Rel_existencia_ventaJpaController() {
        emf = Persistence.createEntityManagerFactory("StockSystemPU");
    } 

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rel_existencia_venta rel_existencia_venta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta rel_venta = rel_existencia_venta.getRel_venta();
            if (rel_venta != null) {
                rel_venta = em.getReference(rel_venta.getClass(), rel_venta.getId());
                rel_existencia_venta.setRel_venta(rel_venta);
            }
            Existencia rel_existencia = rel_existencia_venta.getRel_existencia();
            if (rel_existencia != null) {
                rel_existencia = em.getReference(rel_existencia.getClass(), rel_existencia.getId());
                rel_existencia_venta.setRel_existencia(rel_existencia);
            }
            em.persist(rel_existencia_venta);
            if (rel_venta != null) {
                rel_venta.getVenta_rel().add(rel_existencia_venta);
                rel_venta = em.merge(rel_venta);
            }
            if (rel_existencia != null) {
                rel_existencia.getExistencia_rel().add(rel_existencia_venta);
                rel_existencia = em.merge(rel_existencia);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rel_existencia_venta rel_existencia_venta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rel_existencia_venta persistentRel_existencia_venta = em.find(Rel_existencia_venta.class, rel_existencia_venta.getId());
            Venta rel_ventaOld = persistentRel_existencia_venta.getRel_venta();
            Venta rel_ventaNew = rel_existencia_venta.getRel_venta();
            Existencia rel_existenciaOld = persistentRel_existencia_venta.getRel_existencia();
            Existencia rel_existenciaNew = rel_existencia_venta.getRel_existencia();
            if (rel_ventaNew != null) {
                rel_ventaNew = em.getReference(rel_ventaNew.getClass(), rel_ventaNew.getId());
                rel_existencia_venta.setRel_venta(rel_ventaNew);
            }
            if (rel_existenciaNew != null) {
                rel_existenciaNew = em.getReference(rel_existenciaNew.getClass(), rel_existenciaNew.getId());
                rel_existencia_venta.setRel_existencia(rel_existenciaNew);
            }
            rel_existencia_venta = em.merge(rel_existencia_venta);
            if (rel_ventaOld != null && !rel_ventaOld.equals(rel_ventaNew)) {
                rel_ventaOld.getVenta_rel().remove(rel_existencia_venta);
                rel_ventaOld = em.merge(rel_ventaOld);
            }
            if (rel_ventaNew != null && !rel_ventaNew.equals(rel_ventaOld)) {
                rel_ventaNew.getVenta_rel().add(rel_existencia_venta);
                rel_ventaNew = em.merge(rel_ventaNew);
            }
            if (rel_existenciaOld != null && !rel_existenciaOld.equals(rel_existenciaNew)) {
                rel_existenciaOld.getExistencia_rel().remove(rel_existencia_venta);
                rel_existenciaOld = em.merge(rel_existenciaOld);
            }
            if (rel_existenciaNew != null && !rel_existenciaNew.equals(rel_existenciaOld)) {
                rel_existenciaNew.getExistencia_rel().add(rel_existencia_venta);
                rel_existenciaNew = em.merge(rel_existenciaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = rel_existencia_venta.getId();
                if (findRel_existencia_venta(id) == null) {
                    throw new NonexistentEntityException("The rel_existencia_venta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rel_existencia_venta rel_existencia_venta;
            try {
                rel_existencia_venta = em.getReference(Rel_existencia_venta.class, id);
                rel_existencia_venta.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rel_existencia_venta with id " + id + " no longer exists.", enfe);
            }
            Venta rel_venta = rel_existencia_venta.getRel_venta();
            if (rel_venta != null) {
                rel_venta.getVenta_rel().remove(rel_existencia_venta);
                rel_venta = em.merge(rel_venta);
            }
            Existencia rel_existencia = rel_existencia_venta.getRel_existencia();
            if (rel_existencia != null) {
                rel_existencia.getExistencia_rel().remove(rel_existencia_venta);
                rel_existencia = em.merge(rel_existencia);
            }
            em.remove(rel_existencia_venta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rel_existencia_venta> findRel_existencia_ventaEntities() {
        return findRel_existencia_ventaEntities(true, -1, -1);
    }

    public List<Rel_existencia_venta> findRel_existencia_ventaEntities(int maxResults, int firstResult) {
        return findRel_existencia_ventaEntities(false, maxResults, firstResult);
    }

    private List<Rel_existencia_venta> findRel_existencia_ventaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rel_existencia_venta.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Rel_existencia_venta findRel_existencia_venta(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rel_existencia_venta.class, id);
        } finally {
            em.close();
        }
    }

    public int getRel_existencia_ventaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rel_existencia_venta> rt = cq.from(Rel_existencia_venta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
