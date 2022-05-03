package com.example.restaurantedb.utilidades;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurantedb.R;
import com.example.restaurantedb.clases.Franquicia;
import com.example.restaurantedb.controladores.FranquiciaController;

public class NuevaFranquiciaActivity extends AppCompatActivity {


    EditText edt_nomF=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_franquicia);
        edt_nomF= findViewById(R.id.edt_NombreFranquicia);
    }
    public void insertarFranquicia(View view){
        String nFra=String.valueOf(edt_nomF.getText());
        if(nFra.isEmpty()){
            edt_nomF.setError("Por favor introduce Franquicia");
            return;
        }
        AlertDialog.Builder aler= new AlertDialog.Builder(this);
        aler.setTitle("Guardar Franquicia?");
        aler.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Franquicia f1=new Franquicia(nFra);
                boolean inserOk= FranquiciaController.insertarFranquicia(f1);
                mostrarToast(inserOk);
            }
        });
        aler.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        aler.show();



    }

    private void mostrarToast(boolean inserOk) {
        if(inserOk){
            Toast.makeText(this,"La franquicia se ha guardado",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"La franquicia no se ha guardado",Toast.LENGTH_LONG).show();
        }
    }
}
