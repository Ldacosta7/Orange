package com.example.orange;

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

public class FragmentIntervention extends Fragment implements View.OnClickListener, IIterventionObserver {


    private Button buttonAccueil;
    private ArrayList<Intervention> interventions = new ArrayList<Intervention>();
    private ListView listViewIntervention;
    private ISelectButtonHomePage listener;

    public void setListener(ISelectButtonHomePage listener){this.listener = listener; };

    public void refresh(){
        ApiOrange.getAllInterventions(getActivity(), 2, this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_intervention,null);

        listViewIntervention = v.findViewById(R.id.listViewIntervention);

        buttonAccueil = v.findViewById(R.id.buttonAccueil);
        buttonAccueil.setOnClickListener(this);

        this.refresh();
        return v;
    }



    @Override
    public void onReceiveIntervention(ArrayList<Intervention> interventions) {
        this.interventions= interventions;
        InterventionAdapter adapter = new InterventionAdapter(getActivity(), this.interventions);
        listViewIntervention.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(buttonAccueil)) {
            listener.onSelectAccueil();
        }
    }
}
