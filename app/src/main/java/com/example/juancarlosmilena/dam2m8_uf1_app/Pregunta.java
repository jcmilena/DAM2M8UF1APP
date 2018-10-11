package com.example.juancarlosmilena.dam2m8_uf1_app;

public class Pregunta {

    int id_pregunta;
    boolean respuesta;

    public Pregunta(int id_pregunta, boolean respuesta) {
        this.id_pregunta = id_pregunta;
        this.respuesta = respuesta;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }
}
