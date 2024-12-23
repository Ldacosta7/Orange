package com.example.orange;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentMateriel extends Fragment implements View.OnClickListener, IMaterielObserver {

    private Button buttonAccueil;
    private ArrayList<Materiel> materiels = new ArrayList<Materiel>();
    private ListView listViewMateriel;
    private ISelectButtonHomePage listener;

    public void setListener(ISelectButtonHomePage listener){this.listener = listener; };


    public void refresh(){
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);

        if(sharedPref.getString("role", "client").equals("client"))
        {
            ApiOrange.getMaterielsUser(getActivity(), sharedPref.getInt("identifiant", 0), this);

        }else
        {
            ApiOrange.getAllMateriels(getActivity(), this);
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_intervention,null);

        listViewMateriel = v.findViewById(R.id.listViewIntervention);

        buttonAccueil = v.findViewById(R.id.buttonAccueil);
        buttonAccueil.setOnClickListener(this);



        this.refresh();
        return v;
    }


    @Override
    public void onClick(View v) {
        if (v.equals(buttonAccueil)) {
            listener.onSelectAccueil();
        }
    }

    @Override
    public void onReceiveMateriel(ArrayList<Materiel> materiels) {
        this.materiels= materiels;
        MaterielAdapter adapter = new MaterielAdapter(getActivity(), this.materiels);
        listViewMateriel.setAdapter(adapter);
    }
}
