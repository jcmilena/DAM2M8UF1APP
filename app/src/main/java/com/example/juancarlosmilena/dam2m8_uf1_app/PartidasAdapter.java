package com.example.juancarlosmilena.dam2m8_uf1_app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PartidasAdapter extends RecyclerView.Adapter<PartidasAdapter.PartidasHolder> {

    List<Partida> clasificacion;
    LayoutInflater inflater;

    public PartidasAdapter(List<Partida> clasificacion, LayoutInflater inflater) {
        this.clasificacion = clasificacion;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public PartidasHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PartidasHolder(inflater, viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull PartidasHolder partidasHolder, int i) {

        partidasHolder.fecha.setText(clasificacion.get(i).getFecha().toString());
        partidasHolder.jugador.setText(clasificacion.get(i).getJugador());
        partidasHolder.puntos.setText(Integer.toString(clasificacion.get(i).getPuntuacion()));
    }


    @Override
    public int getItemCount() {
        return clasificacion.size();
    }

    public class PartidasHolder extends RecyclerView.ViewHolder{

        TextView fecha, jugador, puntos;

        public PartidasHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.partida_holder, parent, false));

            fecha = itemView.findViewById(R.id.fecha);
            jugador = itemView.findViewById(R.id.jug);
            puntos = itemView.findViewById(R.id.puntu);


        }
    }
}
