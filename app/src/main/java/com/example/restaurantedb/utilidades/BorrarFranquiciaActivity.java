package com.example.restaurantedb.utilidades;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurantedb.R;
import com.example.restaurantedb.clases.Franquicia;
import com.example.restaurantedb.controladores.FranquiciaController;

import java.util.ArrayList;

public class BorrarFranquiciaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner sp_fran = null;
    Franquicia fseleccionada = null;
    ArrayAdapter<Franquicia> adapter = null;
    ArrayList<Franquicia> franquicia = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_franquicia);
        sp_fran = (Spinner) findViewById(R.id.sp_franquicia);
        if(sp_fran != null) {
            sp_fran.setOnItemSelectedListener(this);
            franquicia = FranquiciaController.obtenerFranquicias();
            if(franquicia != null) {
                adapter = new ArrayAdapter<Franquicia>(this, R.layout.item_franquicia, franquicia);
                sp_fran.setAdapter(adapter);
            }
        }
    }

    public void mostrarToast(String mensaje)
    {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void borrarFranquicia(View view) {
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("borrar la franquicia?");
        //alerta1.setMessage(" no -> cancelar, si-> guardar");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(fseleccionada == null)
                {
                    mostrarToast("selecciona una provincia");
                    return;
                }
                //borrar provincia
                boolean borradoOK = FranquiciaController.borrarFranquicia(fseleccionada);

                if(borradoOK)
                {
                    mostrarToast("franquicia borrada correctamente");

                    adapter.clear();
                    franquicia = FranquiciaController.obtenerFranquicias();
                    adapter.addAll(franquicia);

                }
                else{
                    mostrarToast("No se pudo borrar la franquicia");
                }
            }
        });
        alerta1.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerta1.show();


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Franquicia f = (Franquicia) sp_fran.getItemAtPosition(position);
        fseleccionada = f;
        //  Toast.makeText(this, p.getNombre(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
