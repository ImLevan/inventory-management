package com.mycompany.gestioninventario.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String usuario;
    private String nombre;
    private String contrasena;
    
    @OneToMany(mappedBy = "existencia_usuario")
    private List<Existencia> usuario_existencias;
    
    @OneToMany(mappedBy = "venta_usuario")
    private List<Venta> usuario_ventas;

    public Usuario() {
    }

    public Usuario(int id, String usuario, String nombre, String contrasena, List<Existencia> usuario_existencias, List<Venta> usuario_ventas) {
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.usuario_existencias = usuario_existencias;
        this.usuario_ventas = usuario_ventas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Existencia> getUsuario_existencias() {
        return usuario_existencias;
    }

    public void setUsuario_existencias(List<Existencia> usuario_existencias) {
        this.usuario_existencias = usuario_existencias;
    }

    public List<Venta> getUsuario_ventas() {
        return usuario_ventas;
    }

    public void setUsuario_ventas(List<Venta> usuario_ventas) {
        this.usuario_ventas = usuario_ventas;
    }
    
    
}
