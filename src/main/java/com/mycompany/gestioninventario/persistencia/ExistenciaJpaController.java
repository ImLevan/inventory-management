/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventario.persistencia;

import com.mycompany.gestioninventario.logica.Existencia;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.gestioninventario.logica.Producto;
import com.mycompany.gestioninventario.logica.Proveedor;
import com.mycompany.gestioninventario.logica.Usuario;
import com.mycompany.gestioninventario.logica.Rel_existencia_venta;
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
public class ExistenciaJpaController implements Serializable {

    public ExistenciaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public ExistenciaJpaController() {
        emf = Persistence.createEntityManagerFactory("StockSystemPU");
    } 

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Existencia existencia) {
        if (existencia.getExistencia_rel() == null) {
            existencia.setExistencia_rel(new ArrayList<Rel_existencia_venta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto existencia_producto = existencia.getExistencia_producto();
            if (existencia_producto != null) {
                existencia_producto = em.getReference(existencia_producto.getClass(), existencia_producto.getId());
                existencia.setExistencia_producto(existencia_producto);
            }
            Proveedor existencia_proveedor = existencia.getExistencia_proveedor();
            if (existencia_proveedor != null) {
                existencia_proveedor = em.getReference(existencia_proveedor.getClass(), existencia_proveedor.getId());
                existencia.setExistencia_proveedor(existencia_proveedor);
            }
            Usuario existencia_usuario = existencia.getExistencia_usuario();
            if (existencia_usuario != null) {
                existencia_usuario = em.getReference(existencia_usuario.getClass(), existencia_usuario.getId());
                existencia.setExistencia_usuario(existencia_usuario);
            }
            List<Rel_existencia_venta> attachedExistencia_rel = new ArrayList<Rel_existencia_venta>();
            for (Rel_existencia_venta existencia_relRel_existencia_ventaToAttach : existencia.getExistencia_rel()) {
                existencia_relRel_existencia_ventaToAttach = em.getReference(existencia_relRel_existencia_ventaToAttach.getClass(), existencia_relRel_existencia_ventaToAttach.getId());
                attachedExistencia_rel.add(existencia_relRel_existencia_ventaToAttach);
            }
            existencia.setExistencia_rel(attachedExistencia_rel);
            em.persist(existencia);
            if (existencia_producto != null) {
                existencia_producto.getProducto_existencias().add(existencia);
                existencia_producto = em.merge(existencia_producto);
            }
            if (existencia_proveedor != null) {
                existencia_proveedor.getProveedor_existencias().add(existencia);
                existencia_proveedor = em.merge(existencia_proveedor);
            }
            if (existencia_usuario != null) {
                existencia_usuario.getUsuario_existencias().add(existencia);
                existencia_usuario = em.merge(existencia_usuario);
            }
            for (Rel_existencia_venta existencia_relRel_existencia_venta : existencia.getExistencia_rel()) {
                Existencia oldRel_existenciaOfExistencia_relRel_existencia_venta = existencia_relRel_existencia_venta.getRel_existencia();
                existencia_relRel_existencia_venta.setRel_existencia(existencia);
                existencia_relRel_existencia_venta = em.merge(existencia_relRel_existencia_venta);
                if (oldRel_existenciaOfExistencia_relRel_existencia_venta != null) {
                    oldRel_existenciaOfExistencia_relRel_existencia_venta.getExistencia_rel().remove(existencia_relRel_existencia_venta);
                    oldRel_existenciaOfExistencia_relRel_existencia_venta = em.merge(oldRel_existenciaOfExistencia_relRel_existencia_venta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Existencia existencia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Existencia persistentExistencia = em.find(Existencia.class, existencia.getId());
            Producto existencia_productoOld = persistentExistencia.getExistencia_producto();
            Producto existencia_productoNew = existencia.getExistencia_producto();
            Proveedor existencia_proveedorOld = persistentExistencia.getExistencia_proveedor();
            Proveedor existencia_proveedorNew = existencia.getExistencia_proveedor();
            Usuario existencia_usuarioOld = persistentExistencia.getExistencia_usuario();
            Usuario existencia_usuarioNew = existencia.getExistencia_usuario();
            List<Rel_existencia_venta> existencia_relOld = persistentExistencia.getExistencia_rel();
            List<Rel_existencia_venta> existencia_relNew = existencia.getExistencia_rel();
            if (existencia_productoNew != null) {
                existencia_productoNew = em.getReference(existencia_productoNew.getClass(), existencia_productoNew.getId());
                existencia.setExistencia_producto(existencia_productoNew);
            }
            if (existencia_proveedorNew != null) {
                existencia_proveedorNew = em.getReference(existencia_proveedorNew.getClass(), existencia_proveedorNew.getId());
                existencia.setExistencia_proveedor(existencia_proveedorNew);
            }
            if (existencia_usuarioNew != null) {
                existencia_usuarioNew = em.getReference(existencia_usuarioNew.getClass(), existencia_usuarioNew.getId());
                existencia.setExistencia_usuario(existencia_usuarioNew);
            }
            List<Rel_existencia_venta> attachedExistencia_relNew = new ArrayList<Rel_existencia_venta>();
            for (Rel_existencia_venta existencia_relNewRel_existencia_ventaToAttach : existencia_relNew) {
                existencia_relNewRel_existencia_ventaToAttach = em.getReference(existencia_relNewRel_existencia_ventaToAttach.getClass(), existencia_relNewRel_existencia_ventaToAttach.getId());
                attachedExistencia_relNew.add(existencia_relNewRel_existencia_ventaToAttach);
            }
            existencia_relNew = attachedExistencia_relNew;
            existencia.setExistencia_rel(existencia_relNew);
            existencia = em.merge(existencia);
            if (existencia_productoOld != null && !existencia_productoOld.equals(existencia_productoNew)) {
                existencia_productoOld.getProducto_existencias().remove(existencia);
                existencia_productoOld = em.merge(existencia_productoOld);
            }
            if (existencia_productoNew != null && !existencia_productoNew.equals(existencia_productoOld)) {
                existencia_productoNew.getProducto_existencias().add(existencia);
                existencia_productoNew = em.merge(existencia_productoNew);
            }
            if (existencia_proveedorOld != null && !existencia_proveedorOld.equals(existencia_proveedorNew)) {
                existencia_proveedorOld.getProveedor_existencias().remove(existencia);
                existencia_proveedorOld = em.merge(existencia_proveedorOld);
            }
            if (existencia_proveedorNew != null && !existencia_proveedorNew.equals(existencia_proveedorOld)) {
                existencia_proveedorNew.getProveedor_existencias().add(existencia);
                existencia_proveedorNew = em.merge(existencia_proveedorNew);
            }
            if (existencia_usuarioOld != null && !existencia_usuarioOld.equals(existencia_usuarioNew)) {
                existencia_usuarioOld.getUsuario_existencias().remove(existencia);
                existencia_usuarioOld = em.merge(existencia_usuarioOld);
            }
            if (existencia_usuarioNew != null && !existencia_usuarioNew.equals(existencia_usuarioOld)) {
                existencia_usuarioNew.getUsuario_existencias().add(existencia);
                existencia_usuarioNew = em.merge(existencia_usuarioNew);
            }
            for (Rel_existencia_venta existencia_relOldRel_existencia_venta : existencia_relOld) {
                if (!existencia_relNew.contains(existencia_relOldRel_existencia_venta)) {
                    existencia_relOldRel_existencia_venta.setRel_existencia(null);
                    existencia_relOldRel_existencia_venta = em.merge(existencia_relOldRel_existencia_venta);
                }
            }
            for (Rel_existencia_venta existencia_relNewRel_existencia_venta : existencia_relNew) {
                if (!existencia_relOld.contains(existencia_relNewRel_existencia_venta)) {
                    Existencia oldRel_existenciaOfExistencia_relNewRel_existencia_venta = existencia_relNewRel_existencia_venta.getRel_existencia();
                    existencia_relNewRel_existencia_venta.setRel_existencia(existencia);
                    existencia_relNewRel_existencia_venta = em.merge(existencia_relNewRel_existencia_venta);
                    if (oldRel_existenciaOfExistencia_relNewRel_existencia_venta != null && !oldRel_existenciaOfExistencia_relNewRel_existencia_venta.equals(existencia)) {
                        oldRel_existenciaOfExistencia_relNewRel_existencia_venta.getExistencia_rel().remove(existencia_relNewRel_existencia_venta);
                        oldRel_existenciaOfExistencia_relNewRel_existencia_venta = em.merge(oldRel_existenciaOfExistencia_relNewRel_existencia_venta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = existencia.getId();
                if (findExistencia(id) == null) {
                    throw new NonexistentEntityException("The existencia with id " + id + " no longer exists.");
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
            Existencia existencia;
            try {
                existencia = em.getReference(Existencia.class, id);
                existencia.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The existencia with id " + id + " no longer exists.", enfe);
            }
            Producto existencia_producto = existencia.getExistencia_producto();
            if (existencia_producto != null) {
                existencia_producto.getProducto_existencias().remove(existencia);
                existencia_producto = em.merge(existencia_producto);
            }
            Proveedor existencia_proveedor = existencia.getExistencia_proveedor();
            if (existencia_proveedor != null) {
                existencia_proveedor.getProveedor_existencias().remove(existencia);
                existencia_proveedor = em.merge(existencia_proveedor);
            }
            Usuario existencia_usuario = existencia.getExistencia_usuario();
            if (existencia_usuario != null) {
                existencia_usuario.getUsuario_existencias().remove(existencia);
                existencia_usuario = em.merge(existencia_usuario);
            }
            List<Rel_existencia_venta> existencia_rel = existencia.getExistencia_rel();
            for (Rel_existencia_venta existencia_relRel_existencia_venta : existencia_rel) {
                existencia_relRel_existencia_venta.setRel_existencia(null);
                existencia_relRel_existencia_venta = em.merge(existencia_relRel_existencia_venta);
            }
            em.remove(existencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Existencia> findExistenciaEntities() {
        return findExistenciaEntities(true, -1, -1);
    }

    public List<Existencia> findExistenciaEntities(int maxResults, int firstResult) {
        return findExistenciaEntities(false, maxResults, firstResult);
    }

    private List<Existencia> findExistenciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Existencia.class));
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

    public Existencia findExistencia(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Existencia.class, id);
        } finally {
            em.close();
        }
    }

    public int getExistenciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Existencia> rt = cq.from(Existencia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
