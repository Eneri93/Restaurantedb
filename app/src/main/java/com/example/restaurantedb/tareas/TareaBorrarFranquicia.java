package com.example.restaurantedb.tareas;

import com.example.restaurantedb.clases.Franquicia;
import com.example.restaurantedb.modelos.FranquiciaDB;

import java.util.concurrent.Callable;

public class TareaBorrarFranquicia implements Callable<Boolean> {
    private Franquicia f = null;

    public TareaBorrarFranquicia(Franquicia f) {
        this.f = f;
    }

    @Override
    public Boolean call() throws Exception {
        boolean borradoOK = FranquiciaDB.borrarFranquiciaTabla(f);
        return borradoOK;


    }
}