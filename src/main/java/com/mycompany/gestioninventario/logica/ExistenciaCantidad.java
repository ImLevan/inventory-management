package com.mycompany.gestioninventario.logica;

public class ExistenciaCantidad {
    private int idExistencia;
    private int cantidad;

    public ExistenciaCantidad(int idExistencia, int cantidad) {
        this.idExistencia = idExistencia;
        this.cantidad = cantidad;
    }

    public int getIdExistencia() {
        return idExistencia;
    }

    public int getCantidad() {
        return cantidad;
    }
}
