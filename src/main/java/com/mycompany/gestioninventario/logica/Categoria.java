package com.mycompany.gestioninventario.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nombre;
    
    @OneToMany(mappedBy = "producto_categoria")
    private List<Producto> categoria_productos;

    public Categoria() {
    }

    public Categoria(int id, String nombre, List<Producto> categoria_productos) {
        this.id = id;
        this.nombre = nombre;
        this.categoria_productos = categoria_productos;
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

    public List<Producto> getCategoria_productos() {
        return categoria_productos;
    }

    public void setCategoria_productos(List<Producto> categoria_productos) {
        this.categoria_productos = categoria_productos;
    }
    
    
    
}
