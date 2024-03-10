package com.mycompany.gestioninventario.persistencia;

import com.mycompany.gestioninventario.logica.Categoria;
import com.mycompany.gestioninventario.logica.Existencia;
import com.mycompany.gestioninventario.logica.Producto;
import com.mycompany.gestioninventario.logica.Proveedor;
import com.mycompany.gestioninventario.logica.Rel_existencia_venta;
import com.mycompany.gestioninventario.logica.Usuario;
import com.mycompany.gestioninventario.logica.Venta;
import com.mycompany.gestioninventario.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    CategoriaJpaController categoriaJpa = new CategoriaJpaController();
    ExistenciaJpaController existenciaJpa = new ExistenciaJpaController();
    ProductoJpaController productoJpa = new ProductoJpaController();
    ProveedorJpaController proveedorJpa = new ProveedorJpaController();
    Rel_existencia_ventaJpaController rel_existencia_ventaJpa = new Rel_existencia_ventaJpaController();
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    VentaJpaController ventaJpa = new VentaJpaController();
    
    
    public void guardarUsuario(Usuario user) {
        usuarioJpa.create(user);
    }
    
    public Usuario traerUsuario(int num_usuario) {
        return usuarioJpa.findUsuario(num_usuario);
    }

    public Usuario traerUsuarioPorNombreYContrasenia(String nombreUsuario, String contrasenia) {
        List<Usuario> listaUsuarios = usuarioJpa.findUsuarioEntities();
        
        for(Usuario usu: listaUsuarios){
            if(usu.getUsuario().equals(nombreUsuario) && usu.getContrasena().equals(contrasenia)){
                return usu;
            }
        }
        
        return null;
    }
    
    public List<Usuario> traerUsuarios() {
        return usuarioJpa.findUsuarioEntities();
    }
    
    public void borrarUsuario(int num_usuario) {
        try{
            usuarioJpa.destroy(num_usuario);
        } catch (NonexistentEntityException ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarUsuario(Usuario usuario) {
        try{
            usuarioJpa.edit(usuario);
        }catch (Exception ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarCategoria(int num_categoria) {
        try{
            categoriaJpa.destroy(num_categoria);
        } catch (NonexistentEntityException ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Categoria> traerCategorias() {
        return categoriaJpa.findCategoriaEntities();
    }

    public Categoria traerCategoria(int num_categoria) {
        return categoriaJpa.findCategoria(num_categoria);
    }

    public void modificarCategoria(Categoria categoria) {
        try{
            categoriaJpa.edit(categoria);
        }catch (Exception ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarCategoria(Categoria categoria) {
        categoriaJpa.create(categoria);
    }

    public List<Producto> traerProductos() {
        return productoJpa.findProductoEntities();
    }

    public void borrarProducto(int num_producto) {
        try{
            productoJpa.destroy(num_producto);
        } catch (NonexistentEntityException ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Producto traerProducto(int num_producto) {
       return productoJpa.findProducto(num_producto);
    }
    
    public Producto traerProductoPorNombre(String nombreProducto) {
       List<Producto> productos = this.traerProductos();
       for(Producto producto : productos){
           if(producto.getNombre().equals(nombreProducto)){
               return producto;
           }
       }
       
       return null;
    }

    public void modificarProducto(Producto producto) {
        try{
            productoJpa.edit(producto);
        }catch (Exception ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarProducto(Producto producto) {
        productoJpa.create(producto);
    }

    public List<Proveedor> traerProveedores() {
        return proveedorJpa.findProveedorEntities();
    }

    public void borrarProveedor(int num_proveedor) {
        try{
            proveedorJpa.destroy(num_proveedor);
        } catch (NonexistentEntityException ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Proveedor traerProveedor(int num_proveedor) {
       return proveedorJpa.findProveedor(num_proveedor);
    }
    
    public Proveedor traerProveedorPorNombre(String nombreProveedor) {
       List<Proveedor> proveedores = this.traerProveedores();
       for(Proveedor proveedor : proveedores){
           if(proveedor.getNombre().equals(nombreProveedor)){
               return proveedor;
           }
       }
       
       return null;
    }

    public void modificarProveedor(Proveedor proveedor) {
        try{
            proveedorJpa.edit(proveedor);
        }catch (Exception ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarProveedor(Proveedor proveedor) {
        proveedorJpa.create(proveedor);
    }

    public void guardarExistencia(Existencia existencia) {
        existenciaJpa.create(existencia);
    }

    public void borrarExistencia(int num_existencia) {
        try{
            existenciaJpa.destroy(num_existencia);
        } catch (NonexistentEntityException ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Existencia> traerExistencias() {
        return existenciaJpa.findExistenciaEntities();
    }

    public Existencia traerExistencia(int num_existencia) {
        return existenciaJpa.findExistencia(num_existencia);
    }

    public void modificarExistencia(Existencia existencia) {
        try{
            existenciaJpa.edit(existencia);
        }catch (Exception ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Venta> traerVentas() {
        return ventaJpa.findVentaEntities();
    }

    public void guardarRel_existencia_venta(Rel_existencia_venta rel) {
        rel_existencia_ventaJpa.create(rel);
    }

    public void guardarVenta(Venta venta) {
        ventaJpa.create(venta);
    }

    public Venta traerVenta(int num_venta) {
        return ventaJpa.findVenta(num_venta);
    }
    
    public void modificarRel_existencia_venta(Rel_existencia_venta rel) {
        try{
            rel_existencia_ventaJpa.edit(rel);
        }catch (Exception ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarRel_existencia_venta(int num_rel) {
        try{
            rel_existencia_ventaJpa.destroy(num_rel);
        } catch (NonexistentEntityException ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarVenta(Venta venta) {
        try{
            ventaJpa.edit(venta);
        }catch (Exception ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Rel_existencia_venta> traerRelExistencias() {
        return rel_existencia_ventaJpa.findRel_existencia_ventaEntities();
    }

    public void borrarVenta(int num_venta) {
        try{
            ventaJpa.destroy(num_venta);
        } catch (NonexistentEntityException ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
