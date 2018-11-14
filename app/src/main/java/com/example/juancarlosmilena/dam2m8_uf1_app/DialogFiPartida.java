package com.example.juancarlosmilena.dam2m8_uf1_app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class DialogFiPartida extends DialogFragment {

    DialogFiPartidaListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DialogFiPartidaListener) {
            mListener = (DialogFiPartidaListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("FIN PARTIDA").setMessage("Quieres empezar nueva partida¿")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // indice_pregunta = 0;
                        // actualizar_pregunta();
                        mListener.nueva_partida(0,0);
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // nada
                        dismiss();
                    }
                });

        return builder.create();
    }

    public interface DialogFiPartidaListener{

        void nueva_partida(int ind, int aciert);
    }
}
