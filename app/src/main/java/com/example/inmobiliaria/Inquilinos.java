package com.example.inmobiliaria;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class Inquilinos extends Fragment {
    private ArrayList<Inquilino_item> inquilinos_list=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_inquilinos, container, false);
        ListView listView= view.findViewById(R.id.listView);

        inquilinos_list.add(new Inquilino_item("37505068","Martin","colombo","san martin 827","2657601495"));
        inquilinos_list.add( new Inquilino_item("34505068","Valeria","Veneciano","muelleady 163 depto 30","2657601495"));
        ArrayAdapter<Inquilino_item> adapter = new InquilinoAdapter(getContext(),R.layout.inquilino_item,inquilinos_list,getLayoutInflater());
        listView.setAdapter(adapter);
        ((Principal) getActivity()).getSupportActionBar().setTitle("Inquilinos");
        return view ;
    }


}
