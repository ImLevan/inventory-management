package com.mycompany.gestioninventario.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rel_existencia_venta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    @ManyToOne
    private Venta rel_venta;
    
    @ManyToOne
    private Existencia rel_existencia;
    private int cantidad;
    private float precioUnidad;

    public Rel_existencia_venta() {
    }

    public Rel_existencia_venta(int id, Venta rel_venta, Existencia rel_existencia, int cantidad, float precioUnidad) {
        this.id = id;
        this.rel_venta = rel_venta;
        this.rel_existencia = rel_existencia;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Venta getRel_venta() {
        return rel_venta;
    }

    public void setRel_venta(Venta rel_venta) {
        this.rel_venta = rel_venta;
    }

    public Existencia getRel_existencia() {
        return rel_existencia;
    }

    public void setRel_existencia(Existencia rel_existencia) {
        this.rel_existencia = rel_existencia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(float precioUnidad) {
        this.precioUnidad = precioUnidad;
    }
    
    
}
