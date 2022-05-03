package com.example.restaurantedb.tareas;

import com.example.restaurantedb.clases.Restaurante;
import com.example.restaurantedb.modelos.RestauranteDB;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class TareaMostrarRestaurante implements Callable<ArrayList<Restaurante>> {
    private ArrayList<Restaurante> restaurantes = null;
    @Override
    public ArrayList<Restaurante> call() throws Exception {
        restaurantes = RestauranteDB.obtenerRestaurantes();
        return restaurantes;
    }
}
