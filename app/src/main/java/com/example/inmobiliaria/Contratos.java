package com.example.inmobiliaria;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Contratos extends Fragment {

    private ExpandableListView listView;
    private ContratoAdapter adapter;
    private List<String> listaHeaderPropiedad;
    private HashMap<String,List<Contrato_item>> listaContrato;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contratos, container, false);
        listView = view.findViewById(R.id.expandaContratos);
        initData();
        adapter = new ContratoAdapter(getActivity(),listaHeaderPropiedad,listaContrato);

        listView.setAdapter(adapter);



        ((Principal) getActivity()).getSupportActionBar().setTitle("Contratos");
        return view;
    }
    private  void initData() {
        listaHeaderPropiedad = new ArrayList<>();
        listaContrato = new HashMap<>();

        listaHeaderPropiedad.add("San Martin");
        listaHeaderPropiedad.add("Mulleady");
        List<Contrato_item> san_Martin = new ArrayList<>();
        san_Martin.add(new Contrato_item("17/05/2019","20/05/2020",5000));
        san_Martin.add(new Contrato_item("17/05/2019","20/05/2020",5000));

        List<Contrato_item> mulleady = new ArrayList<>();
        mulleady.add(new Contrato_item("19/05/2019","19/05/2020",4000));
        mulleady.add(new Contrato_item("15/05/2019","19/09/2019",20000));

        listaContrato.put(listaHeaderPropiedad.get(0),san_Martin);
        listaContrato.put(listaHeaderPropiedad.get(1),mulleady);
    }

}
