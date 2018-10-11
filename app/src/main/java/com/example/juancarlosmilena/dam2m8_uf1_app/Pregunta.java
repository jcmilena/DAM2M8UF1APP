package com.example.juancarlosmilena.dam2m8_uf1_app;

public class Pregunta {

    int id_pregunta;
    boolean respuesta;
    int id_pista;

    public int getId_pista() {
        return id_pista;
    }

    public void setId_pista(int id_pista) {
        this.id_pista = id_pista;
    }

    public Pregunta(int id_pregunta, boolean respuesta, int id_pista) {
        this.id_pregunta = id_pregunta;
        this.respuesta = respuesta;
        this.id_pista = id_pista;
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
