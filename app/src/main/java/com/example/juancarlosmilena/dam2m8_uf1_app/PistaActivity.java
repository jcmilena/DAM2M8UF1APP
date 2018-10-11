package com.example.juancarlosmilena.dam2m8_uf1_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class PistaActivity extends AppCompatActivity {

    ImageView mPista;
    int res_pista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pista);

        res_pista = getIntent().getIntExtra("pista_tag", R.drawable.ic_launcher_foreground);

        mPista = findViewById(R.id.id_pista);
        mPista.setImageResource(res_pista);

    }
}
