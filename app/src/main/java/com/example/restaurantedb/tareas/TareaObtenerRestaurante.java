package com.example.restaurantedb.tareas;

import com.example.restaurantedb.clases.Restaurante;
import com.example.restaurantedb.modelos.RestauranteDB;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class TareaObtenerRestaurante implements Callable<ArrayList<Restaurante>> {
    @Override
    public ArrayList<Restaurante> call() throws Exception {
        ArrayList<Restaurante> restaurantes = RestauranteDB.obtenerRestaurantes();
        return restaurantes;
    }
}
