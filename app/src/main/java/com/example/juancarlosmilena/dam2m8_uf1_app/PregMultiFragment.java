package com.example.juancarlosmilena.dam2m8_uf1_app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class PregMultiFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private PreguntasFragment.PreguntasFragmentListener mListener;


    private TextView pregMulti;
    private RadioGroup grup_respostes;
    private RadioButton rbut1, rbut2, rbut3, rbut4;

    public PregMultiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PregMultiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PregMultiFragment newInstance(String param1, String param2) {
        PregMultiFragment fragment = new PregMultiFragment();
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
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_preg_multi, container, false);
        pregMulti = (TextView) view.findViewById(R.id.preg_multi);
        grup_respostes = (RadioGroup) view.findViewById(R.id.respostes_multi);
        rbut1 = (RadioButton) view.findViewById(R.id.rbut1);
        rbut2 = (RadioButton) view.findViewById(R.id.rbut2);
        rbut3 = (RadioButton) view.findViewById(R.id.rbut3);
        rbut4 = (RadioButton) view.findViewById(R.id.rbut4);


        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PreguntasFragment.PreguntasFragmentListener) {
            mListener = (PreguntasFragment.PreguntasFragmentListener) context;
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
    public interface PregMultListener {
        // TODO: Update argument type and name

    }
}
