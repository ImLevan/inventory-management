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
import com.mycompany.gestioninventario.logica.Categoria;
import com.mycompany.gestioninventario.logica.Existencia;
import com.mycompany.gestioninventario.logica.Producto;
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
public class ProductoJpaController implements Serializable {

    public ProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public ProductoJpaController() {
        emf = Persistence.createEntityManagerFactory("StockSystemPU");
    } 

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producto producto) {
        if (producto.getProducto_existencias() == null) {
            producto.setProducto_existencias(new ArrayList<Existencia>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria producto_categoria = producto.getProducto_categoria();
            if (producto_categoria != null) {
                producto_categoria = em.getReference(producto_categoria.getClass(), producto_categoria.getId());
                producto.setProducto_categoria(producto_categoria);
            }
            List<Existencia> attachedProducto_existencias = new ArrayList<Existencia>();
            for (Existencia producto_existenciasExistenciaToAttach : producto.getProducto_existencias()) {
                producto_existenciasExistenciaToAttach = em.getReference(producto_existenciasExistenciaToAttach.getClass(), producto_existenciasExistenciaToAttach.getId());
                attachedProducto_existencias.add(producto_existenciasExistenciaToAttach);
            }
            producto.setProducto_existencias(attachedProducto_existencias);
            em.persist(producto);
            if (producto_categoria != null) {
                producto_categoria.getCategoria_productos().add(producto);
                producto_categoria = em.merge(producto_categoria);
            }
            for (Existencia producto_existenciasExistencia : producto.getProducto_existencias()) {
                Producto oldExistencia_productoOfProducto_existenciasExistencia = producto_existenciasExistencia.getExistencia_producto();
                producto_existenciasExistencia.setExistencia_producto(producto);
                producto_existenciasExistencia = em.merge(producto_existenciasExistencia);
                if (oldExistencia_productoOfProducto_existenciasExistencia != null) {
                    oldExistencia_productoOfProducto_existenciasExistencia.getProducto_existencias().remove(producto_existenciasExistencia);
                    oldExistencia_productoOfProducto_existenciasExistencia = em.merge(oldExistencia_productoOfProducto_existenciasExistencia);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producto producto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto persistentProducto = em.find(Producto.class, producto.getId());
            Categoria producto_categoriaOld = persistentProducto.getProducto_categoria();
            Categoria producto_categoriaNew = producto.getProducto_categoria();
            List<Existencia> producto_existenciasOld = persistentProducto.getProducto_existencias();
            List<Existencia> producto_existenciasNew = producto.getProducto_existencias();
            if (producto_categoriaNew != null) {
                producto_categoriaNew = em.getReference(producto_categoriaNew.getClass(), producto_categoriaNew.getId());
                producto.setProducto_categoria(producto_categoriaNew);
            }
            List<Existencia> attachedProducto_existenciasNew = new ArrayList<Existencia>();
            for (Existencia producto_existenciasNewExistenciaToAttach : producto_existenciasNew) {
                producto_existenciasNewExistenciaToAttach = em.getReference(producto_existenciasNewExistenciaToAttach.getClass(), producto_existenciasNewExistenciaToAttach.getId());
                attachedProducto_existenciasNew.add(producto_existenciasNewExistenciaToAttach);
            }
            producto_existenciasNew = attachedProducto_existenciasNew;
            producto.setProducto_existencias(producto_existenciasNew);
            producto = em.merge(producto);
            if (producto_categoriaOld != null && !producto_categoriaOld.equals(producto_categoriaNew)) {
                producto_categoriaOld.getCategoria_productos().remove(producto);
                producto_categoriaOld = em.merge(producto_categoriaOld);
            }
            if (producto_categoriaNew != null && !producto_categoriaNew.equals(producto_categoriaOld)) {
                producto_categoriaNew.getCategoria_productos().add(producto);
                producto_categoriaNew = em.merge(producto_categoriaNew);
            }
            for (Existencia producto_existenciasOldExistencia : producto_existenciasOld) {
                if (!producto_existenciasNew.contains(producto_existenciasOldExistencia)) {
                    producto_existenciasOldExistencia.setExistencia_producto(null);
                    producto_existenciasOldExistencia = em.merge(producto_existenciasOldExistencia);
                }
            }
            for (Existencia producto_existenciasNewExistencia : producto_existenciasNew) {
                if (!producto_existenciasOld.contains(producto_existenciasNewExistencia)) {
                    Producto oldExistencia_productoOfProducto_existenciasNewExistencia = producto_existenciasNewExistencia.getExistencia_producto();
                    producto_existenciasNewExistencia.setExistencia_producto(producto);
                    producto_existenciasNewExistencia = em.merge(producto_existenciasNewExistencia);
                    if (oldExistencia_productoOfProducto_existenciasNewExistencia != null && !oldExistencia_productoOfProducto_existenciasNewExistencia.equals(producto)) {
                        oldExistencia_productoOfProducto_existenciasNewExistencia.getProducto_existencias().remove(producto_existenciasNewExistencia);
                        oldExistencia_productoOfProducto_existenciasNewExistencia = em.merge(oldExistencia_productoOfProducto_existenciasNewExistencia);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = producto.getId();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
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
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
            Categoria producto_categoria = producto.getProducto_categoria();
            if (producto_categoria != null) {
                producto_categoria.getCategoria_productos().remove(producto);
                producto_categoria = em.merge(producto_categoria);
            }
            List<Existencia> producto_existencias = producto.getProducto_existencias();
            for (Existencia producto_existenciasExistencia : producto_existencias) {
                producto_existenciasExistencia.setExistencia_producto(null);
                producto_existenciasExistencia = em.merge(producto_existenciasExistencia);
            }
            em.remove(producto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto> findProductoEntities() {
        return findProductoEntities(true, -1, -1);
    }

    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto.class));
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

    public Producto findProducto(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
