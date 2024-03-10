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
import com.mycompany.gestioninventario.logica.Usuario;
import com.mycompany.gestioninventario.logica.Rel_existencia_venta;
import com.mycompany.gestioninventario.logica.Venta;
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
public class VentaJpaController implements Serializable {

    public VentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public VentaJpaController() {
        emf = Persistence.createEntityManagerFactory("StockSystemPU");
    } 

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Venta venta) {
        if (venta.getVenta_rel() == null) {
            venta.setVenta_rel(new ArrayList<Rel_existencia_venta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario venta_usuario = venta.getVenta_usuario();
            if (venta_usuario != null) {
                venta_usuario = em.getReference(venta_usuario.getClass(), venta_usuario.getId());
                venta.setVenta_usuario(venta_usuario);
            }
            List<Rel_existencia_venta> attachedVenta_rel = new ArrayList<Rel_existencia_venta>();
            for (Rel_existencia_venta venta_relRel_existencia_ventaToAttach : venta.getVenta_rel()) {
                venta_relRel_existencia_ventaToAttach = em.getReference(venta_relRel_existencia_ventaToAttach.getClass(), venta_relRel_existencia_ventaToAttach.getId());
                attachedVenta_rel.add(venta_relRel_existencia_ventaToAttach);
            }
            venta.setVenta_rel(attachedVenta_rel);
            em.persist(venta);
            if (venta_usuario != null) {
                venta_usuario.getUsuario_ventas().add(venta);
                venta_usuario = em.merge(venta_usuario);
            }
            for (Rel_existencia_venta venta_relRel_existencia_venta : venta.getVenta_rel()) {
                Venta oldRel_ventaOfVenta_relRel_existencia_venta = venta_relRel_existencia_venta.getRel_venta();
                venta_relRel_existencia_venta.setRel_venta(venta);
                venta_relRel_existencia_venta = em.merge(venta_relRel_existencia_venta);
                if (oldRel_ventaOfVenta_relRel_existencia_venta != null) {
                    oldRel_ventaOfVenta_relRel_existencia_venta.getVenta_rel().remove(venta_relRel_existencia_venta);
                    oldRel_ventaOfVenta_relRel_existencia_venta = em.merge(oldRel_ventaOfVenta_relRel_existencia_venta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Venta venta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta persistentVenta = em.find(Venta.class, venta.getId());
            Usuario venta_usuarioOld = persistentVenta.getVenta_usuario();
            Usuario venta_usuarioNew = venta.getVenta_usuario();
            List<Rel_existencia_venta> venta_relOld = persistentVenta.getVenta_rel();
            List<Rel_existencia_venta> venta_relNew = venta.getVenta_rel();
            if (venta_usuarioNew != null) {
                venta_usuarioNew = em.getReference(venta_usuarioNew.getClass(), venta_usuarioNew.getId());
                venta.setVenta_usuario(venta_usuarioNew);
            }
            List<Rel_existencia_venta> attachedVenta_relNew = new ArrayList<Rel_existencia_venta>();
            for (Rel_existencia_venta venta_relNewRel_existencia_ventaToAttach : venta_relNew) {
                venta_relNewRel_existencia_ventaToAttach = em.getReference(venta_relNewRel_existencia_ventaToAttach.getClass(), venta_relNewRel_existencia_ventaToAttach.getId());
                attachedVenta_relNew.add(venta_relNewRel_existencia_ventaToAttach);
            }
            venta_relNew = attachedVenta_relNew;
            venta.setVenta_rel(venta_relNew);
            venta = em.merge(venta);
            if (venta_usuarioOld != null && !venta_usuarioOld.equals(venta_usuarioNew)) {
                venta_usuarioOld.getUsuario_ventas().remove(venta);
                venta_usuarioOld = em.merge(venta_usuarioOld);
            }
            if (venta_usuarioNew != null && !venta_usuarioNew.equals(venta_usuarioOld)) {
                venta_usuarioNew.getUsuario_ventas().add(venta);
                venta_usuarioNew = em.merge(venta_usuarioNew);
            }
            for (Rel_existencia_venta venta_relOldRel_existencia_venta : venta_relOld) {
                if (!venta_relNew.contains(venta_relOldRel_existencia_venta)) {
                    venta_relOldRel_existencia_venta.setRel_venta(null);
                    venta_relOldRel_existencia_venta = em.merge(venta_relOldRel_existencia_venta);
                }
            }
            for (Rel_existencia_venta venta_relNewRel_existencia_venta : venta_relNew) {
                if (!venta_relOld.contains(venta_relNewRel_existencia_venta)) {
                    Venta oldRel_ventaOfVenta_relNewRel_existencia_venta = venta_relNewRel_existencia_venta.getRel_venta();
                    venta_relNewRel_existencia_venta.setRel_venta(venta);
                    venta_relNewRel_existencia_venta = em.merge(venta_relNewRel_existencia_venta);
                    if (oldRel_ventaOfVenta_relNewRel_existencia_venta != null && !oldRel_ventaOfVenta_relNewRel_existencia_venta.equals(venta)) {
                        oldRel_ventaOfVenta_relNewRel_existencia_venta.getVenta_rel().remove(venta_relNewRel_existencia_venta);
                        oldRel_ventaOfVenta_relNewRel_existencia_venta = em.merge(oldRel_ventaOfVenta_relNewRel_existencia_venta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = venta.getId();
                if (findVenta(id) == null) {
                    throw new NonexistentEntityException("The venta with id " + id + " no longer exists.");
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
            Venta venta;
            try {
                venta = em.getReference(Venta.class, id);
                venta.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The venta with id " + id + " no longer exists.", enfe);
            }
            Usuario venta_usuario = venta.getVenta_usuario();
            if (venta_usuario != null) {
                venta_usuario.getUsuario_ventas().remove(venta);
                venta_usuario = em.merge(venta_usuario);
            }
            List<Rel_existencia_venta> venta_rel = venta.getVenta_rel();
            for (Rel_existencia_venta venta_relRel_existencia_venta : venta_rel) {
                venta_relRel_existencia_venta.setRel_venta(null);
                venta_relRel_existencia_venta = em.merge(venta_relRel_existencia_venta);
            }
            em.remove(venta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Venta> findVentaEntities() {
        return findVentaEntities(true, -1, -1);
    }

    public List<Venta> findVentaEntities(int maxResults, int firstResult) {
        return findVentaEntities(false, maxResults, firstResult);
    }

    private List<Venta> findVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Venta.class));
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

    public Venta findVenta(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Venta.class, id);
        } finally {
            em.close();
        }
    }

    public int getVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Venta> rt = cq.from(Venta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
