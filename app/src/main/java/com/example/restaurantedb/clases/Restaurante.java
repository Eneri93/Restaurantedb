package com.example.restaurantedb.clases;

import java.io.Serializable;

public class Restaurante  implements Serializable {

    private int idRest;
    private String nombre;
    private double facturcion;
    private int idFra;

    public Restaurante(int idRest, String nombre, double facturcion, int idFra) {
        this.idRest = idRest;
        this.nombre = nombre;
        this.facturcion = facturcion;
        this.idFra = idFra;
    }

    public Restaurante() {
        this.idRest = 0;
        this.nombre = "";
        this.facturcion = 0;
        this.idFra = 1;
    }

    public Restaurante(String nombre, double facturcion, int idFra) {
        this.nombre = nombre;
        this.facturcion = facturcion;
        this.idFra = idFra;
    }

    public int getIdRest() {
        return idRest;
    }

    public void setIdRest(int idRest) {
        this.idRest = idRest;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getFacturcion() {
        return facturcion;
    }

    public void setFacturcion(double facturcion) {
        this.facturcion = facturcion;
    }

    public int getIdFra() {
        return idFra;
    }

    public void setIdFra(int idFra) {
        this.idFra = idFra;
    }
}
