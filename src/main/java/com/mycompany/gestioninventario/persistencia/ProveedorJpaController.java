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
import com.mycompany.gestioninventario.logica.Existencia;
import com.mycompany.gestioninventario.logica.Proveedor;
import com.mycompany.gestioninventario.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author imlevan
 */
public class ProveedorJpaController implements Serializable {

    public ProveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public ProveedorJpaController() {
        emf = Persistence.createEntityManagerFactory("StockSystemPU");
    } 

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proveedor proveedor) {
        if (proveedor.getProveedor_existencias() == null) {
            proveedor.setProveedor_existencias(new ArrayList<Existencia>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Existencia> attachedProveedor_existencias = new ArrayList<Existencia>();
            for (Existencia proveedor_existenciasExistenciaToAttach : proveedor.getProveedor_existencias()) {
                proveedor_existenciasExistenciaToAttach = em.getReference(proveedor_existenciasExistenciaToAttach.getClass(), proveedor_existenciasExistenciaToAttach.getId());
                attachedProveedor_existencias.add(proveedor_existenciasExistenciaToAttach);
            }
            proveedor.setProveedor_existencias(attachedProveedor_existencias);
            em.persist(proveedor);
            for (Existencia proveedor_existenciasExistencia : proveedor.getProveedor_existencias()) {
                Proveedor oldExistencia_proveedorOfProveedor_existenciasExistencia = proveedor_existenciasExistencia.getExistencia_proveedor();
                proveedor_existenciasExistencia.setExistencia_proveedor(proveedor);
                proveedor_existenciasExistencia = em.merge(proveedor_existenciasExistencia);
                if (oldExistencia_proveedorOfProveedor_existenciasExistencia != null) {
                    oldExistencia_proveedorOfProveedor_existenciasExistencia.getProveedor_existencias().remove(proveedor_existenciasExistencia);
                    oldExistencia_proveedorOfProveedor_existenciasExistencia = em.merge(oldExistencia_proveedorOfProveedor_existenciasExistencia);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proveedor proveedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor persistentProveedor = em.find(Proveedor.class, proveedor.getId());
            List<Existencia> proveedor_existenciasOld = persistentProveedor.getProveedor_existencias();
            List<Existencia> proveedor_existenciasNew = proveedor.getProveedor_existencias();
            List<Existencia> attachedProveedor_existenciasNew = new ArrayList<Existencia>();
            for (Existencia proveedor_existenciasNewExistenciaToAttach : proveedor_existenciasNew) {
                proveedor_existenciasNewExistenciaToAttach = em.getReference(proveedor_existenciasNewExistenciaToAttach.getClass(), proveedor_existenciasNewExistenciaToAttach.getId());
                attachedProveedor_existenciasNew.add(proveedor_existenciasNewExistenciaToAttach);
            }
            proveedor_existenciasNew = attachedProveedor_existenciasNew;
            proveedor.setProveedor_existencias(proveedor_existenciasNew);
            proveedor = em.merge(proveedor);
            for (Existencia proveedor_existenciasOldExistencia : proveedor_existenciasOld) {
                if (!proveedor_existenciasNew.contains(proveedor_existenciasOldExistencia)) {
                    proveedor_existenciasOldExistencia.setExistencia_proveedor(null);
                    proveedor_existenciasOldExistencia = em.merge(proveedor_existenciasOldExistencia);
                }
            }
            for (Existencia proveedor_existenciasNewExistencia : proveedor_existenciasNew) {
                if (!proveedor_existenciasOld.contains(proveedor_existenciasNewExistencia)) {
                    Proveedor oldExistencia_proveedorOfProveedor_existenciasNewExistencia = proveedor_existenciasNewExistencia.getExistencia_proveedor();
                    proveedor_existenciasNewExistencia.setExistencia_proveedor(proveedor);
                    proveedor_existenciasNewExistencia = em.merge(proveedor_existenciasNewExistencia);
                    if (oldExistencia_proveedorOfProveedor_existenciasNewExistencia != null && !oldExistencia_proveedorOfProveedor_existenciasNewExistencia.equals(proveedor)) {
                        oldExistencia_proveedorOfProveedor_existenciasNewExistencia.getProveedor_existencias().remove(proveedor_existenciasNewExistencia);
                        oldExistencia_proveedorOfProveedor_existenciasNewExistencia = em.merge(oldExistencia_proveedorOfProveedor_existenciasNewExistencia);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = proveedor.getId();
                if (findProveedor(id) == null) {
                    throw new NonexistentEntityException("The proveedor with id " + id + " no longer exists.");
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
            Proveedor proveedor;
            try {
                proveedor = em.getReference(Proveedor.class, id);
                proveedor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proveedor with id " + id + " no longer exists.", enfe);
            }
            List<Existencia> proveedor_existencias = proveedor.getProveedor_existencias();
            for (Existencia proveedor_existenciasExistencia : proveedor_existencias) {
                proveedor_existenciasExistencia.setExistencia_proveedor(null);
                proveedor_existenciasExistencia = em.merge(proveedor_existenciasExistencia);
            }
            em.remove(proveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proveedor> findProveedorEntities() {
        return findProveedorEntities(true, -1, -1);
    }

    public List<Proveedor> findProveedorEntities(int maxResults, int firstResult) {
        return findProveedorEntities(false, maxResults, firstResult);
    }

    private List<Proveedor> findProveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proveedor.class));
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

    public Proveedor findProveedor(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proveedor> rt = cq.from(Proveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
