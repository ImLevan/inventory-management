package com.mycompany.gestioninventario.logica;

import com.mycompany.gestioninventario.persistencia.ControladoraPersistencia;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void guardarUsuario(String usuario, String contrasenia, String nombre) {
        Usuario user = new Usuario();
        user.setUsuario(usuario);
        user.setContrasena(contrasenia);
        user.setNombre(nombre);
        
        controlPersis.guardarUsuario(user);
    }

    public Usuario traerUsuario(int num_usuario) {
        return controlPersis.traerUsuario(num_usuario);
    }
    
    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }

    public boolean validarUsuario(String nombreUsuario, String contrasenia) {
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasenia)) {
                return true;
            }
        }

        return false;
    }

    public Usuario traerUsuarioPorNombreYContrasenia(String nombreUsuario, String contrasenia) {
        return controlPersis.traerUsuarioPorNombreYContrasenia(nombreUsuario, contrasenia);
    }
    
    public void borrarUsuario(int num_usuario) {
        controlPersis.borrarUsuario(num_usuario);
    }
    
    public void modificarUsuario(Usuario usuario, String nombreUsuario, String contrasenia, String nombre) {
        usuario.setUsuario(nombreUsuario);
        usuario.setContrasena(contrasenia);
        usuario.setNombre(nombre);
        
       
        controlPersis.modificarUsuario(usuario);
    }


    public List<Categoria> traerCategorias() {
        return controlPersis.traerCategorias();
    }

    public void borrarCategoria(int num_categoria) {
        controlPersis.borrarCategoria(num_categoria);
    }

    public Categoria traerCategoria(int num_categoria) {
        return controlPersis.traerCategoria(num_categoria);
    }

    public void modificarCategoria(Categoria categoria, String nombre) {
        categoria.setNombre(nombre);
        controlPersis.modificarCategoria(categoria);
    }

    public void guardarCategoria(String nombre) {
        Categoria categoria = new Categoria();
        categoria.setNombre(nombre);
        controlPersis.guardarCategoria(categoria);
    }

    public Categoria traerCategoriaPorNombre(String nombreCategoria) {
        List<Categoria> categorias = this.traerCategorias();

        for (Categoria cat : categorias) {
            if (cat.getNombre().equals(nombreCategoria)) {
                return cat;
            }
        }
        return null;
    }

    public List<Producto> traerProductos() {
        return controlPersis.traerProductos();
    }

    public void borrarProducto(int num_producto) {
        controlPersis.borrarProducto(num_producto);
    }

    public Producto traerProducto(int num_producto) {
        return controlPersis.traerProducto(num_producto);
    }

    public Producto traerProductoPorNombre(String nombreProducto) {
        return controlPersis.traerProductoPorNombre(nombreProducto);
    }

    public void modificarProducto(Producto producto, Categoria categoria, String nombre, String marca, String descripcion) {
        producto.setProducto_categoria(categoria);
        producto.setNombre(nombre);
        producto.setMarca(marca);
        producto.setDescripcion(descripcion);

        controlPersis.modificarProducto(producto);
    }

    public void guardarProducto(Categoria categoriaSeleccionada, String nombre, String marca, String descripcion) {
        Producto producto = new Producto();
        producto.setProducto_categoria(categoriaSeleccionada);
        producto.setNombre(nombre);
        producto.setMarca(marca);
        producto.setDescripcion(descripcion);

        controlPersis.guardarProducto(producto);
    }

    public List<Proveedor> traerProveedores() {
        return controlPersis.traerProveedores();
    }

    public void borrarProveedor(int num_proveedor) {
        controlPersis.borrarProveedor(num_proveedor);
    }

    public Proveedor traerProveedor(int num_proveedor) {
        return controlPersis.traerProveedor(num_proveedor);
    }

    public Proveedor traerProveedorPorNombre(String nombreProveedor) {
        return controlPersis.traerProveedorPorNombre(nombreProveedor);
    }

    public void modificarProveedor(Proveedor proveedor, String nombre, String email, String telefono, String direccion) {
        proveedor.setNombre(nombre);
        proveedor.setEmail(email);
        proveedor.setTelefono(telefono);
        proveedor.setDireccion(direccion);

        controlPersis.modificarProveedor(proveedor);
    }

    public void guardarProveedor(String nombre, String email, String telefono, String direccion) {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(nombre);
        proveedor.setEmail(email);
        proveedor.setTelefono(telefono);
        proveedor.setDireccion(direccion);

        controlPersis.guardarProveedor(proveedor);
    }

    public void guardarExistencia(Categoria categoriaSeleccionada, Producto productoSeleccionado, Proveedor proveedorSeleccionado, String fecha, Float precioCompra, Float precioVenta, int cantidad, String nota, Usuario usuario) {
        productoSeleccionado.setProducto_categoria(categoriaSeleccionada);
        Existencia existencia = new Existencia();
        existencia.setExistencia_producto(productoSeleccionado);
        existencia.setExistencia_proveedor(proveedorSeleccionado);
        existencia.setExistencia_usuario(usuario);

        DateTimeFormatter formatterSoloFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = LocalDate.parse(fecha, formatterSoloFecha).atStartOfDay();
        existencia.setFechaLlegada(dateTime);
        existencia.setPrecioCompra(precioCompra);
        existencia.setPrecioVenta(precioVenta);
        existencia.setStockInicial(cantidad);
        existencia.setStockActual(cantidad);
        existencia.setNota(nota);

        productoSeleccionado.getProducto_existencias().add(existencia);
        proveedorSeleccionado.getProveedor_existencias().add(existencia);
        usuario.getUsuario_existencias().add(existencia);

        controlPersis.guardarExistencia(existencia);
    }

    public void borrarExistencia(int num_existencia) {
        controlPersis.borrarExistencia(num_existencia);
    }

    public List<Existencia> traerExistencias() {
        return controlPersis.traerExistencias();
    }

    public Existencia traerExistencia(int num_existencia) {
        return controlPersis.traerExistencia(num_existencia);
    }

    public void modificarExistencia(Existencia existencia, Categoria categoriaSeleccionada, Producto productoSeleccionado, Proveedor proveedorSeleccionado, String fecha, Float precioCompra, Float precioVenta, int cantidad, String nota, Usuario usuario) {
        productoSeleccionado.setProducto_categoria(categoriaSeleccionada);
        existencia.setExistencia_producto(productoSeleccionado);
        existencia.setExistencia_proveedor(proveedorSeleccionado);
        existencia.setExistencia_usuario(usuario);
        DateTimeFormatter formatterSoloFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = LocalDate.parse(fecha, formatterSoloFecha).atStartOfDay();
        existencia.setFechaLlegada(dateTime);
        existencia.setPrecioCompra(precioCompra);
        existencia.setPrecioVenta(precioVenta);
        existencia.setStockInicial(cantidad);
        existencia.setStockActual(cantidad);
        existencia.setNota(nota);

        controlPersis.modificarExistencia(existencia);
    }

    public List<Rel_existencia_venta> traerRelExistencias() {
        return controlPersis.traerRelExistencias();
    }

    public void borrarRel_existencia_venta(int num_rel) {
        controlPersis.borrarRel_existencia_venta(num_rel);
    }

    public int existenciasTotales() {
        List<Existencia> existencias = this.traerExistencias();
        int totalExistencias = 0;

        for (Existencia ex : existencias) {
            totalExistencias += ex.getStockInicial();
        }

        return totalExistencias;
    }

    public int existenciasActuales() {
        List<Existencia> existencias = this.traerExistencias();
        int actualExistencias = 0;

        for (Existencia ex : existencias) {
            actualExistencias += ex.getStockActual();
        }

        return actualExistencias;
    }

    public int existenciasVendidas() {
        return this.existenciasTotales() - this.existenciasActuales();
    }

    public Venta traerVenta(int num_venta) {
        return controlPersis.traerVenta(num_venta);
    }

    public List<Venta> traerVentas() {
        return controlPersis.traerVentas();
    }
    
    public float importeVendido(){
        float importeTotal = 0;
        List<Venta> ventas = this.traerVentas();        
        for(Venta venta : ventas){
            importeTotal += venta.getMontoTotal();
        }
        
        return importeTotal;
    }
    
    public float beneficioNeto(){
        float beneficioTotal = 0;
        List<Venta> ventas = this.traerVentas();        
        for(Venta venta : ventas){
            float montoTotal = venta.getMontoTotal();
            float existenciaPagada = this.montoDeExistencias(venta);
            beneficioTotal += montoTotal - existenciaPagada;
        }
        
        return beneficioTotal;
    }
    
    private float montoDeExistencias(Venta venta){
        float montoFinal = 0;     
        List<Rel_existencia_venta> relaciones = venta.getVenta_rel();
        for(Rel_existencia_venta relacion : relaciones){
            float montoCompra = relacion.getCantidad() * relacion.getRel_existencia().getPrecioCompra();
            montoFinal += montoCompra; 
        }
        
        return montoFinal;
    }
    
    public float gananciasActuales() {
        float gastosEnExistencia = 0;    
        float ganancias = 0;
        List<Existencia> existencias = this.traerExistencias();
        
        for(Existencia ex : existencias) {
            gastosEnExistencia += ex.getPrecioCompra() * ex.getStockInicial();
        }
        
        ganancias -= gastosEnExistencia;
        
        return ganancias + this.importeVendido();
    }

    public void guardarVenta(Usuario usuario, float montoTotal, List<ExistenciaCantidad> existenciasCantidad) {
        Venta venta = new Venta();
        LocalDateTime fechaHoy = LocalDateTime.now();
        venta.setFecha(fechaHoy);
        venta.setMontoTotal(montoTotal);
        venta.setVenta_usuario(usuario);

        List<Rel_existencia_venta> ventaRel = new ArrayList<>();

        venta.setVenta_rel(ventaRel);

        usuario.getUsuario_ventas().add(venta);

        controlPersis.guardarVenta(venta);

        venta.setVenta_rel(crearRelaciones(existenciasCantidad, venta));
    }

    private List<Rel_existencia_venta> crearRelaciones(List<ExistenciaCantidad> existenciasCantidad, Venta venta) {
        List<Rel_existencia_venta> lista = new ArrayList<>();

        for (ExistenciaCantidad excant : existenciasCantidad) {
            Existencia ex = this.traerExistencia(excant.getIdExistencia());

            if (ex != null) { // Asegurémonos de que la Existencia existe
                Rel_existencia_venta rel = new Rel_existencia_venta();
                rel.setCantidad(excant.getCantidad());
                rel.setPrecioUnidad(ex.getPrecioVenta());
                rel.setRel_existencia(ex);
                rel.setRel_venta(venta);

                controlPersis.guardarRel_existencia_venta(rel);

                ex.getExistencia_rel().add(rel);

                if (excant.getCantidad() <= ex.getStockActual()) {
                    ex.setStockActual(ex.getStockActual() - excant.getCantidad());
                }

                controlPersis.modificarExistencia(ex);
            } else {

                System.out.println("Existencia no encontrada para id");
            }
        }

        return lista;
    }

    public void modificarVenta(Venta venta, Usuario usuario, float montoTotal, List<ExistenciaCantidad> existenciasCantidad) {
        LocalDateTime fechaHoy = LocalDateTime.now();
        venta.setId(venta.getId());
        venta.setFecha(fechaHoy);
        venta.setMontoTotal(montoTotal);

        controlPersis.modificarVenta(venta);

        venta.setVenta_rel(modificarRelaciones(existenciasCantidad, venta));

    }

    private List<Rel_existencia_venta> modificarRelaciones(List<ExistenciaCantidad> existenciasCantidad, Venta venta) {
        List<Rel_existencia_venta> lista = new ArrayList<>();
        //Restablezco el stock
        reestablecerStock(venta);

        //Borro las relaciones antiguas y seteo las nuevas
        borrarRelacionesExistencia(venta);

        for (ExistenciaCantidad excant : existenciasCantidad) {
            Existencia ex = this.traerExistencia(excant.getIdExistencia());

            if (ex != null) { // Asegurémonos de que la Existencia existe
                Rel_existencia_venta rel = new Rel_existencia_venta();
                rel.setCantidad(excant.getCantidad());
                rel.setPrecioUnidad(ex.getPrecioVenta());
                rel.setRel_existencia(ex);
                rel.setRel_venta(venta);

                controlPersis.guardarRel_existencia_venta(rel);

                ex.getExistencia_rel().add(rel);

                if (excant.getCantidad() <= ex.getStockActual()) {
                    ex.setStockActual(ex.getStockActual() - excant.getCantidad());
                }

                controlPersis.modificarExistencia(ex);
            } else {

                System.out.println("Existencia no encontrada");
            }
        }

        return lista;
    }

    private void reestablecerStock(Venta venta) {
        for (Rel_existencia_venta relEx : venta.getVenta_rel()) {
            Existencia ex = relEx.getRel_existencia();

            if (ex != null) { // Asegurémonos de que la Existencia existe
                ex.setStockActual(ex.getStockActual() + relEx.getCantidad());

                controlPersis.modificarExistencia(ex);
            } else {
                System.out.println("Existencia no encontrada");
            }
        }
    }

    private void borrarRelacionesExistencia(Venta venta) {
        List<Rel_existencia_venta> lista = venta.getVenta_rel();
        Iterator<Rel_existencia_venta> iterator = lista.iterator();

        while (iterator.hasNext()) {
            Rel_existencia_venta relacion = iterator.next();
            Existencia existencia = relacion.getRel_existencia();
            List<Rel_existencia_venta> existenciaRel = existencia.getExistencia_rel();

            existenciaRel.remove(relacion);

            controlPersis.modificarExistencia(existencia);

            // Borro la relación también
            this.borrarRel_existencia_venta(relacion.getId());

            // Uso el iterador para eliminar el elemento actual
            iterator.remove();
        }
    }

    public void borrarVenta(int num_venta) {

        Venta venta = this.traerVenta(num_venta);

        reestablecerStock(venta);
        borrarRelacionesExistencia(venta);

        for (Rel_existencia_venta relacion : venta.getVenta_rel()) {
            controlPersis.borrarRel_existencia_venta(relacion.getId());
        }

        Usuario usuario = venta.getVenta_usuario();
        List<Venta> ventasUsuario = usuario.getUsuario_ventas();

        // Almacena los índices de las ventas que deseas eliminar
        List<Integer> indicesAEliminar = new ArrayList<>();

        for (int i = 0; i < ventasUsuario.size(); i++) {
            if (ventasUsuario.get(i).getId() == num_venta) {
                indicesAEliminar.add(i);
            }
        }

        // Elimina las ventas después del bucle
        for (int i : indicesAEliminar) {
            ventasUsuario.remove(i);
        }

        usuario.setUsuario_ventas(ventasUsuario);

        controlPersis.modificarUsuario(usuario);
        controlPersis.borrarVenta(num_venta);

    }
}
