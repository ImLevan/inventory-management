package com.mycompany.gestioninventario.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Proveedor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    
    @OneToMany(mappedBy = "existencia_proveedor")
    private List<Existencia> proveedor_existencias;

    public Proveedor() {
    }

    public Proveedor(int id, String nombre, String direccion, String telefono, String email, List<Existencia> proveedor_existencias) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.proveedor_existencias = proveedor_existencias;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Existencia> getProveedor_existencias() {
        return proveedor_existencias;
    }

    public void setProveedor_existencias(List<Existencia> proveedor_existencias) {
        this.proveedor_existencias = proveedor_existencias;
    }
    
    
}
