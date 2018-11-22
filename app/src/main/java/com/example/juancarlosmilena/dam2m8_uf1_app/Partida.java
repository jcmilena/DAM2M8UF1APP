package com.example.juancarlosmilena.dam2m8_uf1_app;

import java.util.Date;

public class Partida {

    int puntuacion;
    String jugador;
    Date fecha;

    public Partida(int puntuacion) {
        this.puntuacion = puntuacion;
        this.jugador = "Jugador Inventado";
        this.fecha = new Date();
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public String getJugador() {
        return jugador;
    }

    public Date getFecha() {
        return fecha;
    }
}
