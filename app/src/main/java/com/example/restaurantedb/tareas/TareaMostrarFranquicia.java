package com.example.restaurantedb.tareas;

import com.example.restaurantedb.clases.Franquicia;
import com.example.restaurantedb.modelos.FranquiciaDB;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class TareaMostrarFranquicia implements Callable<ArrayList<Franquicia>> {
    private ArrayList<Franquicia> franquicia = null;
    @Override
    public ArrayList<Franquicia> call() throws Exception {
        franquicia = FranquiciaDB.obtenerFranquicias();
        return franquicia;
    }
}
