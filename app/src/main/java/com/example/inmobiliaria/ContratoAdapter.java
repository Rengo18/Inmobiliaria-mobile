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

public class ContratoAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listaPropiedades;
    private HashMap<String,List<Contrato_item>> listHashMap;


    public ContratoAdapter(Context context, List<String> listaPropiedades, HashMap<String, List<Contrato_item>> listHashMap) {
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
        Contrato_item contratoItem = (Contrato_item)getChild(groupPosition,childPosition);
        if(view==null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.contrato_item,null);
        }
        TextView textViewFechaInicio = view.findViewById(R.id.fechaInicio);
        TextView textViewFechaCierre = view.findViewById(R.id.fechaCierre);
        TextView textViewImporte = view.findViewById(R.id.importe);

        textViewFechaInicio.setText(contratoItem.getFecha_inicio());
        textViewFechaCierre.setText(contratoItem.getFecha_cierre());
        textViewImporte.setText(contratoItem.getImporte()+"");

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
