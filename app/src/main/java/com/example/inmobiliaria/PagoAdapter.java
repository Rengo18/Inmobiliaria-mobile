package com.example.inmobiliaria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class PagoAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listaPropiedades;
    private HashMap<String,List<Pago_item>> listHashMap;


    public PagoAdapter(Context context, List<String> listaPropiedades, HashMap<String, List<Pago_item>> listHashMap) {
        this.context = context;
        this.listaPropiedades = listaPropiedades;
        this.listHashMap = listHashMap;
    }

    @Override
    public int getGroupCount() {
        return listaPropiedades.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return listHashMap.get(listaPropiedades.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return listaPropiedades.get(i);
    }

    @Override
    public Object getChild(int i, int  i1) {
        return listHashMap.get(listaPropiedades.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
        String headerPropiedad = (String)getGroup(groupPosition);
        if(view==null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.propiedad_header,null);
        }
        TextView textViewPropiedades = view.findViewById(R.id.propiedades_header);
        textViewPropiedades.setText(headerPropiedad);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        Pago_item pagoItem = (Pago_item)getChild(groupPosition,childPosition);
        if(view==null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.pago_item,null);
        }
        TextView textViewNroPago = view.findViewById(R.id.fechaInicio);
        TextView textViewFecha = view.findViewById(R.id.fechaCierre);
        TextView textViewImporte = view.findViewById(R.id.importe);

        textViewNroPago.setText(pagoItem.getPago()+"");
        textViewFecha.setText(pagoItem.getFecha());
        textViewImporte.setText(pagoItem.getImporte()+"");

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
