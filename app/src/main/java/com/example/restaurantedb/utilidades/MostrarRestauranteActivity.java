package com.example.restaurantedb.utilidades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantedb.R;
import com.example.restaurantedb.clases.LogoRest;
import com.example.restaurantedb.clases.Restaurante;
import com.example.restaurantedb.clases.listaRestaurantesAdapter;
import com.example.restaurantedb.controladores.LogoRestController;
import com.example.restaurantedb.controladores.RestauranteController;

import java.util.ArrayList;
import java.util.Collections;

public class MostrarRestauranteActivity extends AppCompatActivity {

    private static final int PETICION1 = 1;
    private RecyclerView mRecyclerView;
    private listaRestaurantesAdapter mAdapter;
    private ArrayList<Restaurante> restaurantes;
    private ArrayList<LogoRest> logoRests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_restaurantes);
        //-------------------------------------------------------
        restaurantes = RestauranteController.obtenerRestaurantes();
        logoRests = LogoRestController.obtenerLogoRestaurantes();
        if(restaurantes != null) {

            mRecyclerView = findViewById(R.id.rv_restaurantes);
            // Create an adapter and supply the data to be displayed.
            mAdapter = new listaRestaurantesAdapter(this, restaurantes, logoRests);
            // Connect the adapter with the RecyclerView.
            mRecyclerView.setAdapter(mAdapter);
            // Give the RecyclerView a default layout manager.
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            //------------------------------------------------------------
            ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                    ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                @Override
                public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                    int from = viewHolder.getAdapterPosition();
                    int to = target.getAdapterPosition();
                    Collections.swap(restaurantes, from, to);
                    mAdapter.notifyItemMoved(from, to);
                    return true;
                }

                @Override
                public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                    if(direction == ItemTouchHelper.LEFT)
                    {
                        mostrarToast("ha pulsado izquierda");
                        // Ciudad c = ciudades.get(viewHolder.getAdapterPosition());
                        // CiudadController.borrarCiudad(c);
                        restaurantes.remove(viewHolder.getAdapterPosition());
                        mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                    }
                    if(direction == ItemTouchHelper.RIGHT)
                    {
                        mostrarToast("ha pulsado derecha");
                        restaurantes.remove(viewHolder.getAdapterPosition());
                        mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                    }
                }
            });
            helper.attachToRecyclerView(mRecyclerView);
        }
        else{
            mostrarToast("no se pudo establecer la conexion con la base de datos");
        }
    }

    private void mostrarToast(String texto) {
        Toast.makeText(this,texto, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PETICION1) {
            if (resultCode == RESULT_OK) {
                Restaurante r = (Restaurante) data.getSerializableExtra(NuevoRestauranteActivity.EXTRA_OBJETO_RESTAURANTE);
                restaurantes.add(r);
                // Notify the adapter, that the data has changed.
                mRecyclerView.getAdapter().notifyItemInserted(restaurantes.size());
                // Scroll to the bottom.
                mRecyclerView.smoothScrollToPosition(restaurantes.size());
            }
        }
    }

    public void nuevaCiudad(View view) {
        Intent intent = new Intent(this, NuevoRestauranteActivity.class);
        startActivityForResult(intent, PETICION1);
    }

    public void refrescarCiudades(View view) {
        restaurantes = RestauranteController.obtenerRestaurantes();
        if(restaurantes != null) {
            mAdapter.setListaCiudades(restaurantes);
            mRecyclerView.getAdapter().notifyDataSetChanged();
        }
    }


}
