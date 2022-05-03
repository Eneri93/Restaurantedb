package com.example.restaurantedb.tareas;

import com.example.restaurantedb.clases.Restaurante;
import com.example.restaurantedb.modelos.RestauranteDB;

import java.util.concurrent.Callable;

public class TareaBorrarRestaurante implements Callable<Boolean> {
    private Restaurante r = null;

    public TareaBorrarRestaurante(Restaurante r) {
        this.r = r;
    }

    @Override
    public Boolean call() throws Exception {
        boolean borradoOK = RestauranteDB.borrarRestauranteTabla(r);
        return borradoOK;
    }
}
