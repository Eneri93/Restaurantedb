package com.example.restaurantedb.tareas;

import com.example.restaurantedb.clases.LogoRest;
import com.example.restaurantedb.controladores.RestauranteController;
import com.example.restaurantedb.modelos.RestauranteDB;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class tareaObtenerLogoRes implements Callable<ArrayList<LogoRest>> {

    private int width;
    private int height;

    public tareaObtenerLogoRes(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public ArrayList<LogoRest> call() throws Exception {
        ArrayList<LogoRest> fotosCiudades = RestauranteDB.obtenerLogosRest(this.width,this.height);


        return fotosCiudades;
    }
}
