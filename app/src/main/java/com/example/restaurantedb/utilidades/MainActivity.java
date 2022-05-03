package com.example.restaurantedb.utilidades;

import static com.example.restaurantedb.modelos.conexioncondb.conectarConBaseDeDatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.restaurantedb.R;

import java.sql.Connection;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Connection conexion = conectarConBaseDeDatos();
        if(conexion != null){
            Log.i("sql", "conexion establecida");
            System.out.println("conexion establecida");
        }else{
            Log.i("sql", "error al conectar");
            System.out.println("error al conectar");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void nuevaFranquicia(View view) {
        Intent intent = new Intent(this, NuevaFranquiciaActivity.class);
        startActivity(intent);
    }

    public void borrarFranquicia(View view) {
        Intent intent = new Intent(this, BorrarFranquiciaActivity.class);
        startActivity(intent);
    }

    public void actualizarFranquicia(View view) {
        Intent intent = new Intent(this, ActualizarFranquiciaActivity1.class);
        startActivity(intent);
    }

    public void mostrarRestaurante(View view) {
        Intent intent = new Intent(this, MostrarRestauranteActivity.class);
        startActivity(intent);
    }
    public void nuevoRestaurante(View view) {
        Intent intent = new Intent(this, NuevoRestauranteActivity.class);
        startActivity(intent);
    }

}