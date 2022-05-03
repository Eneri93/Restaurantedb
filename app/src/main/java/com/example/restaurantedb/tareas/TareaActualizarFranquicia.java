package com.example.restaurantedb.tareas;

import com.example.restaurantedb.clases.Franquicia;
import com.example.restaurantedb.modelos.FranquiciaDB;

import java.util.concurrent.Callable;

public class TareaActualizarFranquicia implements Callable<Boolean> {
    private Franquicia f = null;

    public TareaActualizarFranquicia(Franquicia f) {
        this.f = f;
    }

    @Override
    public Boolean call() throws Exception {
        boolean actualizadoOK = FranquiciaDB.actualizarFranquiciaTabla(f);
        return actualizadoOK;


    }
}