package com.mycompany.gestioninventario.persistencia;

import com.mycompany.gestioninventario.logica.Categoria;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.gestioninventario.logica.Producto;
import com.mycompany.gestioninventario.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CategoriaJpaController implements Serializable {

    public CategoriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public CategoriaJpaController() {
        emf = Persistence.createEntityManagerFactory("StockSystemPU");
    } 
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Categoria categoria) {
        if (categoria.getCategoria_productos() == null) {
            categoria.setCategoria_productos(new ArrayList<Producto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Producto> attachedCategoria_productos = new ArrayList<Producto>();
            for (Producto categoria_productosProductoToAttach : categoria.getCategoria_productos()) {
                categoria_productosProductoToAttach = em.getReference(categoria_productosProductoToAttach.getClass(), categoria_productosProductoToAttach.getId());
                attachedCategoria_productos.add(categoria_productosProductoToAttach);
            }
            categoria.setCategoria_productos(attachedCategoria_productos);
            em.persist(categoria);
            for (Producto categoria_productosProducto : categoria.getCategoria_productos()) {
                Categoria oldProducto_categoriaOfCategoria_productosProducto = categoria_productosProducto.getProducto_categoria();
                categoria_productosProducto.setProducto_categoria(categoria);
                categoria_productosProducto = em.merge(categoria_productosProducto);
                if (oldProducto_categoriaOfCategoria_productosProducto != null) {
                    oldProducto_categoriaOfCategoria_productosProducto.getCategoria_productos().remove(categoria_productosProducto);
                    oldProducto_categoriaOfCategoria_productosProducto = em.merge(oldProducto_categoriaOfCategoria_productosProducto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Categoria categoria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria persistentCategoria = em.find(Categoria.class, categoria.getId());
            List<Producto> categoria_productosOld = persistentCategoria.getCategoria_productos();
            List<Producto> categoria_productosNew = categoria.getCategoria_productos();
            List<Producto> attachedCategoria_productosNew = new ArrayList<Producto>();
            for (Producto categoria_productosNewProductoToAttach : categoria_productosNew) {
                categoria_productosNewProductoToAttach = em.getReference(categoria_productosNewProductoToAttach.getClass(), categoria_productosNewProductoToAttach.getId());
                attachedCategoria_productosNew.add(categoria_productosNewProductoToAttach);
            }
            categoria_productosNew = attachedCategoria_productosNew;
            categoria.setCategoria_productos(categoria_productosNew);
            categoria = em.merge(categoria);
            for (Producto categoria_productosOldProducto : categoria_productosOld) {
                if (!categoria_productosNew.contains(categoria_productosOldProducto)) {
                    categoria_productosOldProducto.setProducto_categoria(null);
                    categoria_productosOldProducto = em.merge(categoria_productosOldProducto);
                }
            }
            for (Producto categoria_productosNewProducto : categoria_productosNew) {
                if (!categoria_productosOld.contains(categoria_productosNewProducto)) {
                    Categoria oldProducto_categoriaOfCategoria_productosNewProducto = categoria_productosNewProducto.getProducto_categoria();
                    categoria_productosNewProducto.setProducto_categoria(categoria);
                    categoria_productosNewProducto = em.merge(categoria_productosNewProducto);
                    if (oldProducto_categoriaOfCategoria_productosNewProducto != null && !oldProducto_categoriaOfCategoria_productosNewProducto.equals(categoria)) {
                        oldProducto_categoriaOfCategoria_productosNewProducto.getCategoria_productos().remove(categoria_productosNewProducto);
                        oldProducto_categoriaOfCategoria_productosNewProducto = em.merge(oldProducto_categoriaOfCategoria_productosNewProducto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = categoria.getId();
                if (findCategoria(id) == null) {
                    throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.");
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
            Categoria categoria;
            try {
                categoria = em.getReference(Categoria.class, id);
                categoria.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.", enfe);
            }
            List<Producto> categoria_productos = categoria.getCategoria_productos();
            for (Producto categoria_productosProducto : categoria_productos) {
                categoria_productosProducto.setProducto_categoria(null);
                categoria_productosProducto = em.merge(categoria_productosProducto);
            }
            em.remove(categoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Categoria> findCategoriaEntities() {
        return findCategoriaEntities(true, -1, -1);
    }

    public List<Categoria> findCategoriaEntities(int maxResults, int firstResult) {
        return findCategoriaEntities(false, maxResults, firstResult);
    }

    private List<Categoria> findCategoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Categoria.class));
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

    public Categoria findCategoria(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Categoria.class, id);
        } finally {
            em.close();
        }
    }

    public int getCategoriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Categoria> rt = cq.from(Categoria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
