package com.example.restaurantedb.utilidades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurantedb.R;
import com.example.restaurantedb.clases.Franquicia;
import com.example.restaurantedb.controladores.FranquiciaController;

import java.util.ArrayList;

public class ActualizarFranquiciaActivity1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_OBJETO_FRANQUICIA = "es.irene.actualizarFranquicia.activity";
    Spinner sp_actualizarf = null;
    static Franquicia fseleccionada = null;
    static ArrayAdapter<Franquicia> adapter = null;
    ArrayList<Franquicia> franquicias = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_franquicia1);
        sp_actualizarf = (Spinner) findViewById(R.id.sp_actualizarf);
        if(sp_actualizarf != null) {
            sp_actualizarf.setOnItemSelectedListener(this);
            franquicias = FranquiciaController.obtenerFranquicias();
            if(franquicias != null) {
                adapter = new ArrayAdapter<Franquicia>(this, R.layout.item_franquicia, franquicias);
                sp_actualizarf.setAdapter(adapter);
            }
        }
    }

    public void siguienteactualizarFranquicia(View view) {
        Intent intent = new Intent(this, ActualizarFranquiciaActivity2.class);
        intent.putExtra(EXTRA_OBJETO_FRANQUICIA, fseleccionada);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Franquicia f  = (Franquicia) sp_actualizarf.getItemAtPosition(position);
        fseleccionada = f;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}