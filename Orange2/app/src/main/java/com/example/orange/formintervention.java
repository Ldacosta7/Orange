package com.example.orange;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link formintervention#newInstance} factory method to
 * create an instance of this fragment.
 */
public class formintervention extends Fragment implements View.OnClickListener{

    public formintervention() {
        // Required empty public constructor
    }

    private Button buttonIntervention, buttonAccueil;

    private EditText editDate, editDescription, editDuree, editStatut, editPrix;
    private ISelectButtonHomePage listener;

    public static formintervention newInstance() {
        formintervention fragment = new formintervention();
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
        View v = inflater.inflate(R.layout.fragment_formintervention, container, false);

        buttonIntervention = v.findViewById(R.id.buttonValider);
        buttonAccueil = v.findViewById(R.id.buttonAccueil);

        editDate = v.findViewById(R.id.editTextDate);
        editDescription = v.findViewById(R.id.editTextDescription);
        editDuree = v.findViewById(R.id.editTextDuree);
        editStatut = v.findViewById(R.id.editTextStatut);
        editPrix = v.findViewById(R.id.editTextPrice);

        buttonAccueil.setOnClickListener(this);
        buttonIntervention.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        if (v.equals(buttonIntervention))
        {
            Intervention intervention = new Intervention();
            DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");


            intervention.setDateIntervention(LocalDate.parse(editDate.getText().toString(), formatterDate));
            intervention.setDescription(editDescription.getText().toString());
            intervention.setDuree(Integer.parseInt(editDuree.getText().toString()));
            intervention.setStatut(editStatut.getText().toString());
            intervention.setPrix(Integer.parseInt(editPrix.getText().toString()));
            intervention.setIdClient(2);

            ApiOrange.createIntervention(getActivity(), intervention, listener);

            listener.onSelectAccueil();
        } else if (v.equals(buttonAccueil)) {
            listener.onSelectAccueil();
        }
    }
}