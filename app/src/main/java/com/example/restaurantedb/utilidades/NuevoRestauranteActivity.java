package com.example.restaurantedb.utilidades;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurantedb.R;
import com.example.restaurantedb.clases.Franquicia;
import com.example.restaurantedb.clases.Restaurante;
import com.example.restaurantedb.controladores.FranquiciaController;
import com.example.restaurantedb.controladores.RestauranteController;

import java.util.ArrayList;

public class NuevoRestauranteActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_OBJETO_RESTAURANTE = "es.Irene_restaurantes_nuevoRestauante";
    Spinner sp_nuevaF_rest = null;
    Franquicia fseleccionada = null;
    ArrayAdapter<Franquicia> adapter = null;
    ArrayList<Franquicia> franquicias = null;
    EditText edt_nuevosrest_nombre = null;
    EditText edt_nuevafacturacion_rest = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_restaurante);
        edt_nuevosrest_nombre = findViewById(R.id.edt_nombre_nuevo_restaurante);
        edt_nuevafacturacion_rest = findViewById(R.id.edt_nuevoRest_facturacion);
        sp_nuevaF_rest = (Spinner) findViewById(R.id.sp_nuevoRest_fraqn);
        if(sp_nuevaF_rest != null) {
            sp_nuevaF_rest.setOnItemSelectedListener(this);
            franquicias = FranquiciaController.obtenerFranquicias();
            if(franquicias != null) {
                adapter = new ArrayAdapter<Franquicia>(this, R.layout.item_franquicia, franquicias);
                sp_nuevaF_rest.setAdapter(adapter);
            }
        }
    }
    public void mostrarToast(String mensaje)
    {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void insertarRestaurante(View view) {
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("Guardar restaurante?");
        //alerta1.setMessage(" no -> cancelar, si-> guardar");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(fseleccionada == null)
                {
                    mostrarToast("selecciona una franquicia");
                    return;
                }
                Restaurante t = null;
                try{
                    String nombre = String.valueOf(edt_nuevosrest_nombre.getText());
                    int facturacion = Integer.valueOf(String.valueOf(edt_nuevafacturacion_rest.getText()));
                    t = new Restaurante(nombre, facturacion, fseleccionada.getIdFranquicia());

                }catch (Exception e)
                {
                    mostrarToast("error, revisa los datos introducidos");
                }
                //insertar Ciudad
                boolean insertadoOK = RestauranteController.InsertarRestaurante(t);
                if(insertadoOK)
                {
                    mostrarToast("restaurante insertado correctamente");
                    Intent intent = new Intent();
                    intent.putExtra(EXTRA_OBJETO_RESTAURANTE, t);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                else{
                    mostrarToast("no se pudo crear restaurante");
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
        Franquicia r = (Franquicia) sp_nuevaF_rest.getItemAtPosition(position);
        fseleccionada = r;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}