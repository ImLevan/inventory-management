package com.mycompany.gestioninventario.logica;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Existencia implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    @ManyToOne
    private Producto existencia_producto;
    
    @ManyToOne
    private Proveedor existencia_proveedor;
    
    @ManyToOne
    private Usuario existencia_usuario;
    private LocalDateTime fechaLlegada;
    private float precioCompra;
    private float precioVenta;
    private String nota;
    private int stockInicial;
    private int stockActual;
    
    @OneToMany(mappedBy = "rel_existencia")
    private List<Rel_existencia_venta> existencia_rel;

    public Existencia() {
    }

    public Existencia(int id, Producto existencia_producto, Proveedor existencia_proveedor, Usuario existencia_usuario, LocalDateTime fechaLlegada, float precioCompra, float precioVenta, String nota, int stockInicial, int stockActual, List<Rel_existencia_venta> existencia_rel) {
        this.id = id;
        this.existencia_producto = existencia_producto;
        this.existencia_proveedor = existencia_proveedor;
        this.existencia_usuario = existencia_usuario;
        this.fechaLlegada = fechaLlegada;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.nota = nota;
        this.stockInicial = stockInicial;
        this.stockActual = stockActual;
        this.existencia_rel = existencia_rel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getExistencia_producto() {
        return existencia_producto;
    }

    public void setExistencia_producto(Producto existencia_producto) {
        this.existencia_producto = existencia_producto;
    }

    public Proveedor getExistencia_proveedor() {
        return existencia_proveedor;
    }

    public void setExistencia_proveedor(Proveedor existencia_proveedor) {
        this.existencia_proveedor = existencia_proveedor;
    }

    public Usuario getExistencia_usuario() {
        return existencia_usuario;
    }

    public void setExistencia_usuario(Usuario existencia_usuario) {
        this.existencia_usuario = existencia_usuario;
    }

    public LocalDateTime getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDateTime fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getStockInicial() {
        return stockInicial;
    }

    public void setStockInicial(int stockInicial) {
        this.stockInicial = stockInicial;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public List<Rel_existencia_venta> getExistencia_rel() {
        return existencia_rel;
    }

    public void setExistencia_rel(List<Rel_existencia_venta> existencia_rel) {
        this.existencia_rel = existencia_rel;
    }
    
    
}
