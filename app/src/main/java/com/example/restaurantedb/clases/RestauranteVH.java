package com.example.restaurantedb.clases;

import static com.example.restaurantedb.utilidades.NuevoRestauranteActivity.EXTRA_OBJETO_RESTAURANTE;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantedb.R;
import com.example.restaurantedb.utilidades.MostrarDetalleRestauranteActivity;

public class RestauranteVH extends RecyclerView.ViewHolder implements View.OnClickListener {


public TextView txt_rv_nombreR= null;
public TextView txt_rv_facturacion = null;
public TextView txt_rv_franquicia = null;
public ImageView img_logo = null;

final listaRestaurantesAdapter lrAdapter;

public RestauranteVH(@NonNull View itemView, listaRestaurantesAdapter mAdapter) {
        super(itemView);
        txt_rv_nombreR = (TextView)  itemView.findViewById(R.id.txt_rv_nombreR);
        txt_rv_franquicia = (TextView)  itemView.findViewById(R.id.txt_rv_facturacion);
        txt_rv_facturacion = (TextView)  itemView.findViewById(R.id.txt_rv_franquicia);
        img_logo= (ImageView)  itemView.findViewById(R.id.img_logorest);
        this.lrAdapter = mAdapter;
        itemView.setOnClickListener(this);
        }

@Override
public void onClick(View v) {

        int mPosition = getLayoutPosition();
        Restaurante restaurante = this.lrAdapter.getListaRestaurantes().get(mPosition);


        lrAdapter.notifyDataSetChanged();
        Intent intent = new Intent(lrAdapter.getC(), MostrarDetalleRestauranteActivity.class);

        intent.putExtra(EXTRA_OBJETO_RESTAURANTE, restaurante);
        lrAdapter.getC().startActivity(intent);
        }
        }

