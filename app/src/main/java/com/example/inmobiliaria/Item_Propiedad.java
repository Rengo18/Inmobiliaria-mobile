package com.example.inmobiliaria;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Item_Propiedad.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Item_Propiedad#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Item_Propiedad extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4= "param4";
    private static final String ARG_PARAM5 = "param5";

    // TODO: Rename and change types of parameters
    private String domicilio;
    private String ambiente;
    private String tipo;
    private String uso;
    private String precio;

    private OnFragmentInteractionListener mListener;

    public Item_Propiedad() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Item_Propiedad newInstance(String domicilio, String ambiente,String tipo,String uso,String precio) {
        Item_Propiedad fragment = new Item_Propiedad();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, domicilio);
        args.putString(ARG_PARAM2, ambiente);
        args.putString(ARG_PARAM3,  tipo);
        args.putString(ARG_PARAM4, uso);
        args.putString(ARG_PARAM5, precio);


        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            domicilio = getArguments().getString(ARG_PARAM1);
            ambiente = getArguments().getString(ARG_PARAM2);
            tipo = getArguments().getString(ARG_PARAM3);
            uso = getArguments().getString(ARG_PARAM4);
            precio = getArguments().getString(ARG_PARAM5);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_item__propiedad, container, false);
        EditText editTextDomicilio = vista.findViewById(R.id.Domicilio);
        EditText editTextAmbiente = vista.findViewById(R.id.Ambiente);
        TextView textViewTipo = vista.findViewById(R.id.Tipo);
        TextView textViewUso = vista.findViewById(R.id.Uso);
        EditText editTextPrecio = vista.findViewById(R.id.Precio);

        editTextDomicilio.setText(domicilio);
        editTextAmbiente.setText(ambiente);
        textViewTipo.setText(tipo);
        textViewUso.setText(uso);
        editTextPrecio.setText(precio);

        return vista;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {

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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
