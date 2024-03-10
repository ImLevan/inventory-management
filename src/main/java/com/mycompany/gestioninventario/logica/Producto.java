package com.mycompany.gestioninventario.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Producto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nombre;
    private String marca;
    private String descripcion;
    
    @ManyToOne
    private Categoria producto_categoria;
    
    @OneToMany(mappedBy = "existencia_producto")
    private List<Existencia> producto_existencias;

    public Producto() {
    }

    public Producto(int id, String nombre, String marca, String descripcion, Categoria producto_categoria, List<Existencia> producto_existencias) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.descripcion = descripcion;
        this.producto_categoria = producto_categoria;
        this.producto_existencias = producto_existencias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getProducto_categoria() {
        return producto_categoria;
    }

    public void setProducto_categoria(Categoria producto_categoria) {
        this.producto_categoria = producto_categoria;
    }

    public List<Existencia> getProducto_existencias() {
        return producto_existencias;
    }

    public void setProducto_existencias(List<Existencia> producto_existencias) {
        this.producto_existencias = producto_existencias;
    } 
    
}
