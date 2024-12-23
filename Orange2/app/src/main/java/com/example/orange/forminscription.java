package com.example.orange;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link forminscription#newInstance} factory method to
 * create an instance of this fragment.
 */
public class forminscription extends Fragment implements View.OnClickListener{

    public forminscription() {
        // Required empty public constructor
    }


    private Button buttonInscription, buttonAccueil;
    private EditText editNom, editPrenom, editEmail, editTelephone, editAdresse, editMdp;
    private ISelectButtonHomePage listener;


    public static forminscription newInstance() {
        forminscription fragment = new forminscription();
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
        View v = inflater.inflate(R.layout.fragment_forminscription, container, false);

        buttonInscription = v.findViewById(R.id.buttonInscription);
        buttonAccueil = v.findViewById(R.id.buttonAccueil);

        editNom = v.findViewById(R.id.editTextLastname);
        editPrenom = v.findViewById(R.id.editTextFirstname);
        editEmail = v.findViewById(R.id.editTextEmail);
        editTelephone = v.findViewById(R.id.editTextTel);
        editAdresse = v.findViewById(R.id.editTextAdresse);
        editMdp = v.findViewById(R.id.editTextPassword);


        buttonAccueil.setOnClickListener(this);
        buttonInscription.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {

        if (v.equals(buttonInscription))
        {
            User user = new User();

            user.setNom(editNom.getText().toString());
            user.setPrenom(editPrenom.getText().toString());
            user.setEmail(editEmail.getText().toString());
            user.setTel(editTelephone.getText().toString());
            user.setAdresse(editAdresse.getText().toString());
            user.setPassword(editMdp.getText().toString());
            user.setRoles("client");


            ApiOrange.createUser(getActivity(), user, listener);

        } else if (v.equals(buttonAccueil)) {
            listener.onSelectAccueil();
        }
    }

}