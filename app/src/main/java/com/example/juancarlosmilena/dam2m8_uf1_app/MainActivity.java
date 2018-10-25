package com.example.juancarlosmilena.dam2m8_uf1_app;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PreguntasFragment.PreguntasFragmentListener {




    List<Pregunta> lista_preguntas = new ArrayList<>();
    int indice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        PreguntasFragment frag = new PreguntasFragment();
        fm.beginTransaction().replace(R.id.fragment_container, frag).commit();

    }

    public void mostrar_pista(int id_pista) {

        Intent intent = new Intent(this, PistaActivity.class);
        intent.putExtra("pista_tag", id_pista);
        startActivity(intent);


    }

    public void comprobar_respuesta(boolean pulsado_usuario) {

        if(pulsado_usuario == lista_preguntas.get(indice).isRespuesta()){

            //HAS ACERTADO
        }
        else{
            //HAS FALLADO
        }

    }



    @Override
    public List<Pregunta> cargar_preguntas() {

        lista_preguntas.add(new Pregunta(R.string.pregunta1, true, R.drawable.globos1));
        lista_preguntas.add(new Pregunta(R.string.pregunta2, false, R.drawable.globos2));

        return lista_preguntas;
    }
}
