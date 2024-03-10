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
public class Venta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private LocalDateTime fecha;
    private float montoTotal;
    
    @ManyToOne
    private Usuario venta_usuario;
    
    @OneToMany(mappedBy = "rel_venta")
    private List<Rel_existencia_venta> venta_rel;

    public Venta() {
    }

    public Venta(int id, LocalDateTime fecha, float montoTotal, Usuario venta_usuario, List<Rel_existencia_venta> venta_rel) {
        this.id = id;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
        this.venta_usuario = venta_usuario;
        this.venta_rel = venta_rel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Usuario getVenta_usuario() {
        return venta_usuario;
    }

    public void setVenta_usuario(Usuario venta_usuario) {
        this.venta_usuario = venta_usuario;
    }

    public List<Rel_existencia_venta> getVenta_rel() {
        return venta_rel;
    }

    public void setVenta_rel(List<Rel_existencia_venta> venta_rel) {
        this.venta_rel = venta_rel;
    }
    
    
}
