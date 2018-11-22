package com.example.juancarlosmilena.dam2m8_uf1_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PreguntasFragment.PreguntasFragmentListener, DialogFiPartida.DialogFiPartidaListener, PregMultiFragment.PregMultListener {




    List<Pregunta> lista_preguntas = new ArrayList<>();
    List<PreguntaMulti> lista_pregMulti = new ArrayList<>();
    List<Partida> clasificacion;
    int indice;
    int aciertos;
    int joc = 0;
    Toolbar miToolbar;

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        indice = prefs.getInt("INDICE_PREGUNTA",0);
        aciertos = prefs.getInt("ACIERTOS",0);
        persistencia_xml(0,0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miToolbar = findViewById(R.id.toolbar_m8);
        setSupportActionBar(miToolbar);

        nueva_partida(joc, indice, aciertos);

    }


    public void mostrar_pista(int id_pista) {

        Intent intent = new Intent(this, PistaActivity.class);
        intent.putExtra("pista_tag", id_pista);
        startActivity(intent);


    }

    @Override
    public List<Pregunta> cargar_preguntas() {

        lista_preguntas.add(new Pregunta(R.string.pregunta1, true, R.drawable.globos1));
        lista_preguntas.add(new Pregunta(R.string.pregunta2, false, R.drawable.globos2));

        return lista_preguntas;
    }

    public List<PreguntaMulti> cargar_preguntasMulti() {

        lista_pregMulti.add(new PreguntaMulti(R.string.preguntaMult1, 2, getResources().getIntArray(R.array.RespostaMult1)));
        lista_pregMulti.add(new PreguntaMulti(R.string.preguntaMult2, 3, getResources().getIntArray(R.array.RespostaMult1)));

        return lista_pregMulti;
    }

    @Override
    public void dibujar_Dialog() {
        DialogFragment mi_dialog_fi = new DialogFiPartida();
        mi_dialog_fi.show(getSupportFragmentManager(),null);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.cambio_juego:
                //cambio juego
                joc=(joc==0) ? 1:0;
                nueva_partida(joc,0,0);
            case R.id.juego1 :
                // juego 1
            case R.id.juego2 :
                // juego 2

            default:
                super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();

        persistencia_xml(indice,aciertos);

    }

    private void persistencia_xml(int ind, int aciert) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("INDICE_PREGUNTA", ind);
        editor.putInt("ACIERTOS", aciert);
        editor.commit();
    }

    @Override
    public void nueva_partida(int joc, int ind, int aciert) {

        indice = ind;
        aciertos = aciert;

        FragmentManager fm = getSupportFragmentManager();
        if(joc==0){
            PreguntasFragment frag = new PreguntasFragment();
            fm.beginTransaction().replace(R.id.fragment_container, frag).commit();
        }
        else{
            PregMultiFragment frag = new PregMultiFragment();
            fm.beginTransaction().replace(R.id.fragment_container, frag).commit();
        }




    }

    @Override
    public int actualizar_indice() {

        if(indice>=lista_preguntas.size()-1){
            Log.i("ACIERTOS", "NUMERO ACIERTOS: "+aciertos);
            dibujar_Dialog();
        }

        indice++;

        return indice;
    }

    @Override
    public int comprobar_respuesta(boolean usada) {

        if (indice < lista_preguntas.size()){
            if(usada == lista_preguntas.get(indice).isRespuesta()){
                aciertos++;
            }
        }
        return aciertos;
    }
}
