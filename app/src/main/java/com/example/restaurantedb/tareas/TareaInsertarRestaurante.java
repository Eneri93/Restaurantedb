package com.example.restaurantedb.tareas;

import com.example.restaurantedb.clases.Franquicia;
import com.example.restaurantedb.clases.Restaurante;
import com.example.restaurantedb.modelos.FranquiciaDB;
import com.example.restaurantedb.modelos.RestauranteDB;

import java.util.concurrent.Callable;

public class TareaInsertarRestaurante implements Callable<Boolean> {
private Restaurante r = null;

public TareaInsertarRestaurante(Restaurante r) {
        this.r = r;
        }

@Override
public Boolean call() throws Exception {
        boolean insertadoOK = RestauranteDB.insertarRestauranteTabla(r);
        return insertadoOK;
        }
        }
