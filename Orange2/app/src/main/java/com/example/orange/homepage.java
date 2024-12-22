package com.example.orange;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link homepage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class homepage extends Fragment implements View.OnClickListener {

    public homepage() {
        // Required empty public constructor
    }



    private Button buttonInscription;
    private Button buttonConnexion;
    private Button buttonDemandeMateriel;
    private Button buttonDemandeIntervention;
    private Button buttonAffichageMateriel;
    private Button buttonAffichageIntervention;
    private ISelectButtonHomePage listener;


    public static homepage newInstance(String param1, String param2) {
        homepage fragment = new homepage();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    public void setListener(ISelectButtonHomePage listener)
    {
        this.listener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_homepage, container, false);

        buttonInscription = v.findViewById(R.id.buttonInsription);
        buttonConnexion = v.findViewById(R.id.buttonConnexion);
        buttonDemandeMateriel = v.findViewById(R.id.buttonDemandeMateriel);
        buttonDemandeIntervention = v.findViewById(R.id.buttonDemandeInter);
        buttonAffichageMateriel = v.findViewById(R.id.buttonAffichageMat);
        buttonAffichageIntervention = v.findViewById(R.id.buttonAffichageInt);

        buttonInscription.setOnClickListener(this);
        buttonConnexion.setOnClickListener(this);
        buttonDemandeMateriel.setOnClickListener(this);
        buttonDemandeIntervention.setOnClickListener(this);
        buttonAffichageMateriel.setOnClickListener(this);
        buttonAffichageIntervention.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {

        if (v.equals(buttonInscription))
        {
            listener.onSelectInscription();
        } else if (v.equals(buttonConnexion))
        {
            listener.onSelectConnexion();
        } else if (v.equals(buttonDemandeMateriel))
        {
            listener.onSelectMaterielAjout();
        } else if (v.equals(buttonDemandeIntervention))
        {
            listener.onSelectInterventionsAjout();
        } else if (v.equals(buttonAffichageMateriel))
        {
            listener.onSelectMaterielAffichage();
        } else if (v.equals(buttonAffichageIntervention))
        {
            listener.onSelectInterventionAffichage();
        }
    }
}