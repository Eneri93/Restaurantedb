package com.example.restaurantedb.utilidades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurantedb.R;
import com.example.restaurantedb.clases.Restaurante;

public class MostrarDetalleRestauranteActivity extends AppCompatActivity {
    TextView txt_detalle_nombreR = null;
    TextView txt_detalle_facturacion = null;
    TextView txt_detalle_idfranquicia = null;
    ImageView img_detalle_restaurante= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_detalle_restaurante);
        txt_detalle_nombreR = findViewById(R.id.txt_detalle_nombreR);
        txt_detalle_facturacion= findViewById(R.id.txt_detalle_facturacion);
        txt_detalle_idfranquicia = findViewById(R.id.txt_detalle_franquicia);
        img_detalle_restaurante = findViewById(R.id.img_logorest);
        Intent intent = getIntent();
        if(intent != null)
        {
            Restaurante c = (Restaurante) intent.getSerializableExtra(NuevoRestauranteActivity.EXTRA_OBJETO_RESTAURANTE);
            txt_detalle_nombreR.setText(c.getNombre());

            txt_detalle_facturacion.setText("Facturacion: " + String.valueOf(c.getFacturcion()));
            txt_detalle_idfranquicia.setText("Franquicia: " + String.valueOf(c.getIdFra()));
        }
    }
}