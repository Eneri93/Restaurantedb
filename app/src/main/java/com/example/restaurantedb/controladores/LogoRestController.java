package com.example.restaurantedb.controladores;

import com.example.restaurantedb.clases.LogoRest;
import com.example.restaurantedb.tareas.tareaObtenerLogoRes;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class LogoRestController {
    public static ArrayList<LogoRest> obtenerLogoRestaurantes() {

        ArrayList<LogoRest> logosR = null;
        FutureTask t = new FutureTask (new tareaObtenerLogoRes(100,100));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            logosR= (ArrayList<LogoRest>)t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return logosR;
    }
}
