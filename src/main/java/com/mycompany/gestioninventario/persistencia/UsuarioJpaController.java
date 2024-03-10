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
import com.mycompany.gestioninventario.logica.Usuario;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.gestioninventario.logica.Venta;
import com.mycompany.gestioninventario.persistencia.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author imlevan
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public UsuarioJpaController() {
        emf = Persistence.createEntityManagerFactory("StockSystemPU");
    } 

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getUsuario_existencias() == null) {
            usuario.setUsuario_existencias(new ArrayList<Existencia>());
        }
        if (usuario.getUsuario_ventas() == null) {
            usuario.setUsuario_ventas(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Existencia> attachedUsuario_existencias = new ArrayList<Existencia>();
            for (Existencia usuario_existenciasExistenciaToAttach : usuario.getUsuario_existencias()) {
                usuario_existenciasExistenciaToAttach = em.getReference(usuario_existenciasExistenciaToAttach.getClass(), usuario_existenciasExistenciaToAttach.getId());
                attachedUsuario_existencias.add(usuario_existenciasExistenciaToAttach);
            }
            usuario.setUsuario_existencias(attachedUsuario_existencias);
            List<Venta> attachedUsuario_ventas = new ArrayList<Venta>();
            for (Venta usuario_ventasVentaToAttach : usuario.getUsuario_ventas()) {
                usuario_ventasVentaToAttach = em.getReference(usuario_ventasVentaToAttach.getClass(), usuario_ventasVentaToAttach.getId());
                attachedUsuario_ventas.add(usuario_ventasVentaToAttach);
            }
            usuario.setUsuario_ventas(attachedUsuario_ventas);
            em.persist(usuario);
            for (Existencia usuario_existenciasExistencia : usuario.getUsuario_existencias()) {
                Usuario oldExistencia_usuarioOfUsuario_existenciasExistencia = usuario_existenciasExistencia.getExistencia_usuario();
                usuario_existenciasExistencia.setExistencia_usuario(usuario);
                usuario_existenciasExistencia = em.merge(usuario_existenciasExistencia);
                if (oldExistencia_usuarioOfUsuario_existenciasExistencia != null) {
                    oldExistencia_usuarioOfUsuario_existenciasExistencia.getUsuario_existencias().remove(usuario_existenciasExistencia);
                    oldExistencia_usuarioOfUsuario_existenciasExistencia = em.merge(oldExistencia_usuarioOfUsuario_existenciasExistencia);
                }
            }
            for (Venta usuario_ventasVenta : usuario.getUsuario_ventas()) {
                Usuario oldVenta_usuarioOfUsuario_ventasVenta = usuario_ventasVenta.getVenta_usuario();
                usuario_ventasVenta.setVenta_usuario(usuario);
                usuario_ventasVenta = em.merge(usuario_ventasVenta);
                if (oldVenta_usuarioOfUsuario_ventasVenta != null) {
                    oldVenta_usuarioOfUsuario_ventasVenta.getUsuario_ventas().remove(usuario_ventasVenta);
                    oldVenta_usuarioOfUsuario_ventasVenta = em.merge(oldVenta_usuarioOfUsuario_ventasVenta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getId());
            List<Existencia> usuario_existenciasOld = persistentUsuario.getUsuario_existencias();
            List<Existencia> usuario_existenciasNew = usuario.getUsuario_existencias();
            List<Venta> usuario_ventasOld = persistentUsuario.getUsuario_ventas();
            List<Venta> usuario_ventasNew = usuario.getUsuario_ventas();
            List<Existencia> attachedUsuario_existenciasNew = new ArrayList<Existencia>();
            for (Existencia usuario_existenciasNewExistenciaToAttach : usuario_existenciasNew) {
                usuario_existenciasNewExistenciaToAttach = em.getReference(usuario_existenciasNewExistenciaToAttach.getClass(), usuario_existenciasNewExistenciaToAttach.getId());
                attachedUsuario_existenciasNew.add(usuario_existenciasNewExistenciaToAttach);
            }
            usuario_existenciasNew = attachedUsuario_existenciasNew;
            usuario.setUsuario_existencias(usuario_existenciasNew);
            List<Venta> attachedUsuario_ventasNew = new ArrayList<Venta>();
            for (Venta usuario_ventasNewVentaToAttach : usuario_ventasNew) {
                usuario_ventasNewVentaToAttach = em.getReference(usuario_ventasNewVentaToAttach.getClass(), usuario_ventasNewVentaToAttach.getId());
                attachedUsuario_ventasNew.add(usuario_ventasNewVentaToAttach);
            }
            usuario_ventasNew = attachedUsuario_ventasNew;
            usuario.setUsuario_ventas(usuario_ventasNew);
            usuario = em.merge(usuario);
            for (Existencia usuario_existenciasOldExistencia : usuario_existenciasOld) {
                if (!usuario_existenciasNew.contains(usuario_existenciasOldExistencia)) {
                    usuario_existenciasOldExistencia.setExistencia_usuario(null);
                    usuario_existenciasOldExistencia = em.merge(usuario_existenciasOldExistencia);
                }
            }
            for (Existencia usuario_existenciasNewExistencia : usuario_existenciasNew) {
                if (!usuario_existenciasOld.contains(usuario_existenciasNewExistencia)) {
                    Usuario oldExistencia_usuarioOfUsuario_existenciasNewExistencia = usuario_existenciasNewExistencia.getExistencia_usuario();
                    usuario_existenciasNewExistencia.setExistencia_usuario(usuario);
                    usuario_existenciasNewExistencia = em.merge(usuario_existenciasNewExistencia);
                    if (oldExistencia_usuarioOfUsuario_existenciasNewExistencia != null && !oldExistencia_usuarioOfUsuario_existenciasNewExistencia.equals(usuario)) {
                        oldExistencia_usuarioOfUsuario_existenciasNewExistencia.getUsuario_existencias().remove(usuario_existenciasNewExistencia);
                        oldExistencia_usuarioOfUsuario_existenciasNewExistencia = em.merge(oldExistencia_usuarioOfUsuario_existenciasNewExistencia);
                    }
                }
            }
            for (Venta usuario_ventasOldVenta : usuario_ventasOld) {
                if (!usuario_ventasNew.contains(usuario_ventasOldVenta)) {
                    usuario_ventasOldVenta.setVenta_usuario(null);
                    usuario_ventasOldVenta = em.merge(usuario_ventasOldVenta);
                }
            }
            for (Venta usuario_ventasNewVenta : usuario_ventasNew) {
                if (!usuario_ventasOld.contains(usuario_ventasNewVenta)) {
                    Usuario oldVenta_usuarioOfUsuario_ventasNewVenta = usuario_ventasNewVenta.getVenta_usuario();
                    usuario_ventasNewVenta.setVenta_usuario(usuario);
                    usuario_ventasNewVenta = em.merge(usuario_ventasNewVenta);
                    if (oldVenta_usuarioOfUsuario_ventasNewVenta != null && !oldVenta_usuarioOfUsuario_ventasNewVenta.equals(usuario)) {
                        oldVenta_usuarioOfUsuario_ventasNewVenta.getUsuario_ventas().remove(usuario_ventasNewVenta);
                        oldVenta_usuarioOfUsuario_ventasNewVenta = em.merge(oldVenta_usuarioOfUsuario_ventasNewVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = usuario.getId();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<Existencia> usuario_existencias = usuario.getUsuario_existencias();
            for (Existencia usuario_existenciasExistencia : usuario_existencias) {
                usuario_existenciasExistencia.setExistencia_usuario(null);
                usuario_existenciasExistencia = em.merge(usuario_existenciasExistencia);
            }
            List<Venta> usuario_ventas = usuario.getUsuario_ventas();
            for (Venta usuario_ventasVenta : usuario_ventas) {
                usuario_ventasVenta.setVenta_usuario(null);
                usuario_ventasVenta = em.merge(usuario_ventasVenta);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
