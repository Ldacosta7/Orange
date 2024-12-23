package com.example.orange;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link formmateriel#newInstance} factory method to
 * create an instance of this fragment.
 */
public class formmateriel extends Fragment implements  View.OnClickListener{

    public formmateriel() {
        // Required empty public constructor
    }


    private Button buttonMateriel, buttonAccueil;

    private EditText editDesignation, editModele, editMarque, editDateAchat, editPrix;
    private ISelectButtonHomePage listener;

    public static formmateriel newInstance() {
        formmateriel fragment = new formmateriel();
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
        View v = inflater.inflate(R.layout.fragment_formmateriel, container, false);

        buttonMateriel = v.findViewById(R.id.buttonValider);
        buttonAccueil = v.findViewById(R.id.buttonAccueil);

        editDesignation = v.findViewById(R.id.editTextDesignation);
        editModele = v.findViewById(R.id.editTextModele);
        editMarque = v.findViewById(R.id.editTextMarque);
        editDateAchat = v.findViewById(R.id.editTextDateAchat);
        editPrix = v.findViewById(R.id.editTextPrice);

        buttonAccueil.setOnClickListener(this);
        buttonMateriel.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);

        if (v.equals(buttonMateriel))
        {
            Materiel materiel = new Materiel();
            DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            materiel.setDesignation(editDesignation.getText().toString());
            materiel.setModele(editModele.getText().toString());
            materiel.setMarque(editMarque.getText().toString());
            materiel.setPrix(Integer.parseInt(editPrix.getText().toString()));
            materiel.setDateAchat(LocalDate.parse(editDateAchat.getText().toString(), formatterDate));
            materiel.setIdClient(sharedPref.getInt("identifiant", 0));

            ApiOrange.createMateriel(getActivity(), materiel, listener);

        } else if (v.equals(buttonAccueil)) {
            listener.onSelectAccueil();
        }
    }
}