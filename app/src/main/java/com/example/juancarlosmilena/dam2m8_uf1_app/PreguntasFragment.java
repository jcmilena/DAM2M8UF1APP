package com.example.juancarlosmilena.dam2m8_uf1_app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class PreguntasFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView pregunta;
    Button b_verdadero, b_falso, b_pista;


    List<Pregunta> lista_preguntas = new ArrayList<>();

    int indice = 0;

    private PreguntasFragmentListener mListener;

    public PreguntasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PreguntasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PreguntasFragment newInstance(String param1, String param2) {
        PreguntasFragment fragment = new PreguntasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View VistaFragment = inflater.inflate(R.layout.fragment_preguntas, container , false);

        lista_preguntas = mListener.cargar_preguntas();

        b_verdadero = VistaFragment.findViewById(R.id.verdadero);
        b_falso = VistaFragment.findViewById(R.id.falso);
        pregunta = VistaFragment.findViewById(R.id.texto_pregunta);
        b_pista = VistaFragment.findViewById(R.id.b_Pista);

        actualizar_pregunta();

        b_verdadero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mListener.comprobar_respuesta(true);
                actualizar_indice();
                actualizar_pregunta();

            }
        });

        b_falso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.comprobar_respuesta(false);
                actualizar_indice();
                actualizar_pregunta();

            }
        });

        b_pista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListener.mostrar_pista(lista_preguntas.get(indice).getId_pista());
            }
        });

        return VistaFragment;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PreguntasFragmentListener) {
            mListener = (PreguntasFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public void actualizar_pregunta() {

        pregunta.setText(lista_preguntas.get(indice).getId_pregunta());

    }

    public void actualizar_indice() {

        indice++;
        if(indice==lista_preguntas.size()) {
            indice = 0;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface PreguntasFragmentListener {
        // TODO: Update argument type and name
        void comprobar_respuesta(boolean usada);
        void mostrar_pista(int ResID);
        List<Pregunta> cargar_preguntas();
    }
}
