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


public class Pagos extends Fragment {

    private ExpandableListView listView;
    private PagoAdapter adapter;
    private List<String> listaHeaderPropiedad;
    private HashMap<String,List<Pago_item>> listaPago;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_pagos, container, false);
        listView = view.findViewById(R.id.expandaPagos);
        initData();
        adapter = new PagoAdapter(getActivity(),listaHeaderPropiedad,listaPago);

        listView.setAdapter(adapter);


        ((Principal) getActivity()).getSupportActionBar().setTitle("Pagos");
        return view;
    }

    private  void initData() {
        listaHeaderPropiedad = new ArrayList<>();
        listaPago = new HashMap<>();

        listaHeaderPropiedad.add("San Martin");
        listaHeaderPropiedad.add("Mulleady");
        List<Pago_item> san_Martin = new ArrayList<>();
        san_Martin.add(new Pago_item(1,"19/05/2019",5000));
        san_Martin.add(new Pago_item(2,"19/06/2019",5000));

        List<Pago_item> mulleady = new ArrayList<>();
        mulleady.add(new Pago_item(1,"19/05/2019",40000));
        mulleady.add(new Pago_item(2,"19/06/2019",40000));

        listaPago.put(listaHeaderPropiedad.get(0),san_Martin);
        listaPago.put(listaHeaderPropiedad.get(1),mulleady);
    }
}
