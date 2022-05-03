package com.example.restaurantedb.controladores;

import android.widget.TextView;

import com.example.restaurantedb.clases.Restaurante;
import com.example.restaurantedb.tareas.TareaBorrarRestaurante;
import com.example.restaurantedb.tareas.TareaInsertarRestaurante;
import com.example.restaurantedb.tareas.TareaMostrarRestaurante;
import com.example.restaurantedb.tareas.TareaObtenerRestaurante;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class RestauranteController {

    public static ArrayList<Restaurante> obtenerRestaurantes()
    {
        ArrayList<Restaurante> restDev = null;
        FutureTask t = new FutureTask (new TareaObtenerRestaurante());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            restDev= (ArrayList<Restaurante>)t.get();
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
        return restDev;
    }
    //---------------------------------------------------------------------------
    //-----------------------------------------------------------------------------
    public static void MostrarRest(TextView txt_rest)
    {
        FutureTask t = new FutureTask (new TareaMostrarRestaurante());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            ArrayList<Restaurante> restDev= (ArrayList<Restaurante>)t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
            String texto_rest ="Restaurantes \n";
            if(restDev != null) {
                for (Restaurante c : restDev) {
                    texto_rest += c.toString() + "\n";
                }
                txt_rest.setText(texto_rest);
            }
            else {
                txt_rest.setText("no se recuperaron los restaurantes");
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //---------------------------------------------------------------------------
    public static boolean InsertarRestaurante(Restaurante r)
    {
        FutureTask t = new FutureTask(new TareaInsertarRestaurante(r));
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

    public static boolean borrarRestaurante(Restaurante rseleccionado) {
        FutureTask t = new FutureTask(new TareaBorrarRestaurante(rseleccionado));
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
    //---------------------------------------------------------------------------


}
