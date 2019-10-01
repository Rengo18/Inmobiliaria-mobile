package com.example.inmobiliaria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class InquilinoAdapter extends ArrayAdapter<Inquilino_item> {
    private Context context;
    private List<Inquilino_item> lista;
    private LayoutInflater inflater;
    public InquilinoAdapter(@NonNull Context context, int resource, @NonNull List<Inquilino_item> inquilinos, LayoutInflater inflater) {
        super(context, resource,inquilinos);
        this.context = context;
        this.lista=inquilinos;
        this.inflater=inflater;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View itemView=convertView;
        if(itemView==null){
            itemView=inflater.inflate(R.layout.inquilino_item,parent,false);
        }
        Inquilino_item inquilino =lista.get(position);

        TextView textViewDni = itemView.findViewById(R.id.Dni);
        TextView textViewNombre = itemView.findViewById(R.id.Nombre);
        TextView textViewApellido = itemView.findViewById(R.id.Apellido);
        TextView textViewDireccion = itemView.findViewById(R.id.Direccion);
        TextView textViewTelefono = itemView.findViewById(R.id.Telefono);

        textViewDni.setText(inquilino.getDni());
        textViewNombre.setText(inquilino.getNombre());
        textViewApellido.setText(inquilino.getApellido());
        textViewDireccion.setText(inquilino.getDireccion());
        textViewTelefono.setText(inquilino.getTelefono());

        return itemView;


    }
}
