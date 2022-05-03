package com.example.restaurantedb.tareas;

import com.example.restaurantedb.clases.Franquicia;
import com.example.restaurantedb.modelos.FranquiciaDB;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class TareaObtereFranquicias implements Callable<ArrayList<Franquicia>> {
    @Override
    public ArrayList<Franquicia> call() throws Exception {
        ArrayList<Franquicia> franquicia = FranquiciaDB.obtenerFranquicias();
        return franquicia;
    }
}
