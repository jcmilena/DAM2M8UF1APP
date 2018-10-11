package com.example.juancarlosmilena.dam2m8_uf1_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    TextView pregunta;
    Button b_verdadero, b_falso;

    List<Pregunta> lista_preguntas = new ArrayList<>();
    int indice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista_preguntas.add(new Pregunta(R.string.pregunta1, true));
        lista_preguntas.add(new Pregunta(R.string.pregunta2, false));

        b_verdadero = findViewById(R.id.verdadero);
        b_falso = findViewById(R.id.falso);
        pregunta = findViewById(R.id.texto_pregunta);

        actualizar_pregunta();

        b_verdadero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobar_respuesta(true);
                actualizar_pregunta();
            }
        });

        b_falso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobar_respuesta(false);
                actualizar_pregunta();
            }
        });


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
        indice++;
        if(indice<lista_preguntas.size()){
            indice = 0;
        }

    }
}
