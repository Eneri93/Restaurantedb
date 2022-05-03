package com.example.restaurantedb.tareas;

import com.example.restaurantedb.clases.Franquicia;
import com.example.restaurantedb.modelos.FranquiciaDB;

import java.util.concurrent.Callable;

public class TareaInsertarFranquicia implements Callable<Boolean> {
        private Franquicia f = null;

        public TareaInsertarFranquicia(Franquicia f) {
            this.f = f;
        }

        @Override
        public Boolean call() throws Exception {
            boolean insertadoOK = FranquiciaDB.insertarFranquiciaTabla(f);
            return insertadoOK;

        }
}

