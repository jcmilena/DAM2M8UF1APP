package com.example.juancarlosmilena.dam2m8_uf1_app;

import java.util.List;

public class PreguntaMulti {

    int Id_pregunta;
    int num_resposta;
    int[] id_respostes;

    public PreguntaMulti(int id_pregunta, int num_resposta, int[] id_respostes) {
        Id_pregunta = id_pregunta;
        this.num_resposta = num_resposta;
        this.id_respostes = id_respostes;
    }

    public int getId_pregunta() {
        return Id_pregunta;
    }

    public int getNum_resposta() {
        return num_resposta;
    }

    public void setNum_resposta(int num_resposta) {
        this.num_resposta = num_resposta;
    }

    public int[] getId_respostes() {
        return id_respostes;
    }

    public int getID_resposta(int index){
        return id_respostes[index];
    }

}
