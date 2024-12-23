package com.example.orange;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MaterielAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Materiel> materiels;

    public MaterielAdapter(Context context, ArrayList<Materiel> materiels){
        this.context = context;
        this.materiels = materiels;
    }


    @Override
    public int getCount() { return materiels.size(); }

    @Override
    public Object getItem(int position) { return materiels.get(position); }

    @Override
    public long getItemId(int position) { return materiels.get(position).getId(); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_materiel, parent, false);
        }

        TextView textViewDesc = convertView.findViewById(R.id.textViewMaterielDesignation);
        textViewDesc.setText(materiels.get(position).getDesignation());

        TextView textViewModele = convertView.findViewById(R.id.textViewMaterielModele);
        textViewModele.setText(materiels.get(position).getModele());

        TextView textViewMarque = convertView.findViewById(R.id.textViewMaterielMarque);
        textViewMarque.setText(materiels.get(position).getMarque());

        TextView textViewPrix = convertView.findViewById(R.id.textViewMaterielPrix);
        textViewPrix.setText(materiels.get(position).getPrix()+"");

        TextView textViewDate = convertView.findViewById(R.id.textViewMaterielDate);
        textViewDate.setText(materiels.get(position).getDateAchat().toString());


        return convertView;
    }
}
