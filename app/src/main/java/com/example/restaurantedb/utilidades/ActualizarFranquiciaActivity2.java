package com.example.restaurantedb.utilidades;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurantedb.R;
import com.example.restaurantedb.clases.Franquicia;
import com.example.restaurantedb.controladores.FranquiciaController;

import java.util.ArrayList;

public class ActualizarFranquiciaActivity2 extends AppCompatActivity {

    Franquicia fseleccionada = null;
    EditText edt_actualizar_codF = null;
    EditText edt_actualizar_nombreF = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_franquicia2);
        edt_actualizar_codF = (EditText) findViewById(R.id.edt_actualizar_codF);
        edt_actualizar_nombreF = (EditText) findViewById(R.id.edt_actualizar_nombreF);
        Intent intent = getIntent();
        if(intent != null)
        { fseleccionada = (Franquicia) intent.getSerializableExtra(ActualizarFranquiciaActivity1.EXTRA_OBJETO_FRANQUICIA);
            if(fseleccionada!=null)
            {
                edt_actualizar_codF.setText(String.valueOf(fseleccionada.getIdFranquicia()));
                edt_actualizar_codF.setEnabled(false);
                edt_actualizar_nombreF.setText(fseleccionada.getNombre());
            }
        }
    }

    public void actualizarFranquicia(View view) {
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("Desea actualizar?");
        //alerta1.setMessage(" no -> cancelar, si-> actualizar");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //actualizar provincia
                int idF = Integer.valueOf(String.valueOf(edt_actualizar_codF.getText()));
                String nombreF = String.valueOf(edt_actualizar_nombreF.getText());
                Franquicia f = new Franquicia(idF, nombreF);
                boolean actualizarOK = FranquiciaController.actualizarFranquicia(f);
                // recargar combo (o desde la base de datos volver a solicitar todo, o quitar solamente el item borrado)
                if(actualizarOK)
                {
                    ActualizarFranquiciaActivity1.adapter.clear();
                    ArrayList<Franquicia> franquicias = FranquiciaController.obtenerFranquicias();
                    ActualizarFranquiciaActivity1.adapter.addAll(franquicias);

                    mostrarToast("franquicia actualizada correctamente");
                }
                else{
                    mostrarToast("la franquicia no se pudo actualizar");
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

    public void mostrarToast(String mensaje)
    {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

}