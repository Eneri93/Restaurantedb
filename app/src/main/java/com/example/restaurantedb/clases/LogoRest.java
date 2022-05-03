package com.example.restaurantedb.clases;

import android.graphics.Bitmap;

import java.util.Objects;

public class LogoRest {

private int idlogo;
private Bitmap logo;
private int idRestaurante;

    public LogoRest(int idlogo, Bitmap logo, int idRestaurante) {
        this.idlogo = idlogo;
        this.logo = logo;
        this.idRestaurante = idRestaurante;
    }

    public int getIdlogo() {
        return idlogo;
    }

    public void setIdlogo(int idlogo) {
        this.idlogo = idlogo;
    }

    public Bitmap getLogo() {
        return logo;
    }

    public void setLogo(Bitmap logo) {
        this.logo = logo;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogoRest logoRest = (LogoRest) o;
        return idlogo == logoRest.idlogo && idRestaurante == logoRest.idRestaurante && logo.equals(logoRest.logo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idlogo);
    }

    @Override
    public String toString() {
        return "LogoRest{" +
                "idlogo=" + idlogo +
                ", logo=" + logo +
                ", idRestaurante=" + idRestaurante +
                '}';
    }
}
