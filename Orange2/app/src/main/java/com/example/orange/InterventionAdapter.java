package com.example.orange;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class InterventionAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Intervention> interventions;

    public InterventionAdapter(Context context, ArrayList<Intervention> interventions){
        this.context = context;
        this.interventions = interventions;
    }


    @Override
    public int getCount() { return interventions.size(); }

    @Override
    public Object getItem(int position) { return interventions.get(position); }

    @Override
    public long getItemId(int position) { return interventions.get(position).getId(); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_intervention, parent, false);
        }

        TextView textViewDate = convertView.findViewById(R.id.textViewInterventionDate);
        textViewDate.setText(interventions.get(position).getDateIntervention().toString());

        TextView textViewDesc = convertView.findViewById(R.id.textViewInterventionDescription);
        textViewDesc.setText(interventions.get(position).getDescription());

        TextView textViewDuree = convertView.findViewById(R.id.textViewInterventionDuree);
        textViewDuree.setText(interventions.get(position).getDuree()+"");

        TextView textViewPrix = convertView.findViewById(R.id.textViewInterventionPrix);
        textViewPrix.setText(interventions.get(position).getPrix()+"");

        TextView textViewStatut = convertView.findViewById(R.id.textViewInterventionStatut);
        textViewStatut.setText(interventions.get(position).getStatut());


        return convertView;
    }
}
