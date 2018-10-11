package com.example.juancarlosmilena.dam2m8_uf1_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    TextView pregunta;
    Button b_verdadero, b_falso, b_pista;

    List<Pregunta> lista_preguntas = new ArrayList<>();
    int indice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista_preguntas.add(new Pregunta(R.string.pregunta1, true, R.drawable.globos1));
        lista_preguntas.add(new Pregunta(R.string.pregunta2, false, R.drawable.globos2));

        b_verdadero = findViewById(R.id.verdadero);
        b_falso = findViewById(R.id.falso);
        pregunta = findViewById(R.id.texto_pregunta);
        b_pista = findViewById(R.id.b_Pista);

        actualizar_pregunta();

        b_verdadero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobar_respuesta(true);
                actualizar_indice();
                actualizar_pregunta();

            }
        });

        b_falso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobar_respuesta(false);
                actualizar_indice();
                actualizar_pregunta();

            }
        });

        b_pista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mostrar_pista(lista_preguntas.get(indice).getId_pista());
            }
        });

    }

    private void actualizar_indice() {

        indice++;
        if(indice==lista_preguntas.size()) {
            indice = 0;
        }
    }

    private void mostrar_pista(int id_pista) {

        Intent intent = new Intent(this, PistaActivity.class);
        intent.putExtra("pista_tag", id_pista);
        startActivity(intent);


    }

    private void comprobar_respuesta(boolean pulsado_usuario) {

        if(pulsado_usuario == lista_preguntas.get(indice).isRespuesta()){

            //HAS ACERTADO
        }
        else{
            //HAS FALLADO
        }

    }

    private void actualizar_pregunta() {

        pregunta.setText(lista_preguntas.get(indice).getId_pregunta());

    }
}
