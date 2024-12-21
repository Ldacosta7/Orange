package com.example.orange;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class FragmentFormInscription extends Fragment implements View.OnClickListener {

    private EditText editFirstname, editLastname, editEmail, editTel, editAdresse, editMdp;
    private Button buttonInscritpion;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_forminscription, null);

        editFirstname = v.findViewById(R.id.editTextFirstname);
        editLastname= v.findViewById(R.id.editTextLastname);
        editEmail= v.findViewById(R.id.editTextEmail);
        editTel= v.findViewById(R.id.editTextTel);
        editAdresse= v.findViewById(R.id.editTextAdresse);
        editMdp= v.findViewById(R.id.editTextPassword);

        buttonInscritpion= v.findViewById(R.id.buttonInsription);
        buttonInscritpion.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {

    }
}
