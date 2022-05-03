package com.example.restaurantedb.clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantedb.R;

import java.util.ArrayList;

public class listaRestaurantesAdapter extends RecyclerView.Adapter<RestauranteVH> {

    private Context c;
    private ArrayList<Restaurante> listaRestaurantes;
    private  ArrayList<LogoRest> listaLogosR;
    private LayoutInflater mInflater;

    public listaRestaurantesAdapter(Context c, ArrayList<Restaurante> listaRestaurantes, ArrayList<LogoRest> logoRests) {
        this.c = c;
        this.listaRestaurantes = listaRestaurantes;
        this.listaLogosR = logoRests;
        mInflater = LayoutInflater.from(c);
    }

    public ArrayList<LogoRest> getListaLogosR() {
        return listaLogosR;
    }

    public void setListaFotosCiudades(ArrayList<LogoRest> listaLogosR) {
        this.listaLogosR = listaLogosR;
    }

    @NonNull
    @Override
    public RestauranteVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.item_recyclerview_franquicia, parent, false);
        return new RestauranteVH(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RestauranteVH holder, int position) {
        Restaurante RActual = listaRestaurantes.get(position);
        holder.txt_rv_nombreR.setText("Ciudad: " + RActual.getNombre());
        holder.txt_rv_facturacion.setText(String.valueOf("Facturacion: " + RActual.getFacturcion()));
        holder.txt_rv_franquicia.setText(String.valueOf("idFranquicia: " + RActual.getIdFra()));
        if(this.listaLogosR != null)
        {
            for(LogoRest fc: this.listaLogosR)
            {
                if(fc.getIdlogo()==RActual.getIdFra())
                {
                    holder.img_logo.setImageBitmap(fc.getLogo());
                    break;
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return listaRestaurantes.size();
    }

    public Context getC() {
        return c;
    }

    public void setC(Context c) {
        this.c = c;
    }

    public ArrayList<Restaurante> getListaRestaurantes() {
        return listaRestaurantes;
    }

    public void setListaCiudades(ArrayList<Restaurante> listaRestaurantes) {
        this.listaRestaurantes = listaRestaurantes;
    }
}
