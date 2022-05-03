package com.example.restaurantedb.controladores;

import com.example.restaurantedb.clases.Franquicia;
import com.example.restaurantedb.tareas.TareaActualizarFranquicia;
import com.example.restaurantedb.tareas.TareaBorrarFranquicia;
import com.example.restaurantedb.tareas.TareaInsertarFranquicia;
import com.example.restaurantedb.tareas.TareaObtereFranquicias;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FranquiciaController {

    public static boolean insertarFranquicia(Franquicia f) {
        FutureTask t = new FutureTask(new TareaInsertarFranquicia(f));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean insercionOK = false;
        try {
            insercionOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return insercionOK;
        }
    }

    //---------------------------------------------------------------------------

    public static ArrayList<Franquicia> obtenerFranquicias()
    {
        ArrayList<Franquicia> fDevueltas = null;
        FutureTask t = new FutureTask (new TareaObtereFranquicias());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            fDevueltas= (ArrayList<Franquicia>)t.get();
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
        return fDevueltas;
    }
    //---------------------------------------------------------------------------
    public static boolean   borrarFranquicia(Franquicia f) {
        FutureTask t = new FutureTask(new TareaBorrarFranquicia(f));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean borradoOK = false;
        try {
            borradoOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return borradoOK;
        }
    }

    public static boolean actualizarFranquicia(Franquicia f) {
        FutureTask t = new FutureTask(new TareaActualizarFranquicia(f));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean actualizadoOK = false;
        try {
            actualizadoOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return actualizadoOK;
        }
    }
}


