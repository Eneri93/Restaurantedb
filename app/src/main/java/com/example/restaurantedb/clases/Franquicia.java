package com.example.restaurantedb.clases;

import java.io.Serializable;
import java.util.Objects;

public class Franquicia implements Serializable {

    private int idFranquicia;
    private String nombre;

    public Franquicia(int idFranquicia, String nombre) {
        this.idFranquicia = idFranquicia;
        this.nombre = nombre;
        //----------------------------------------
    }

    public Franquicia(String nFra) {
        this.idFranquicia = 0;
        this.nombre = nFra;
    }

    public int getIdFranquicia() {
        return idFranquicia;
    }

    public void setIdFranquicia(int idFranquicia) {
        this.idFranquicia = idFranquicia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Franquicia that = (Franquicia) o;
        return idFranquicia == that.idFranquicia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFranquicia);
    }

    @Override
    public String toString() {

        return nombre;
    }
}
