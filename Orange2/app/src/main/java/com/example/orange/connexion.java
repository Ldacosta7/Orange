package com.example.orange;

import android.os.Bundle;

import androidx.datastore.preferences.core.Preferences;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import io.reactivex.Single;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link connexion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class connexion extends Fragment implements  View.OnClickListener, IConnexion{

    public connexion() {
        // Required empty public constructor
    }

    private Button buttonConnexion, buttonAccueil;
    private EditText editEmail, editMdp;
    private ISelectButtonHomePage listener;

    public static connexion newInstance() {
        connexion fragment = new connexion();
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
        View v = inflater.inflate(R.layout.fragment_connexion, container, false);

        buttonConnexion = v.findViewById(R.id.buttonConnexion);
        buttonAccueil = v.findViewById(R.id.buttonAccueil);

        editEmail = v.findViewById(R.id.editTextEmail);
        editMdp = v.findViewById(R.id.editTextPassword);

        buttonAccueil.setOnClickListener(this);
        buttonConnexion.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {

        if (v.equals(buttonConnexion))
        {
            User user = new User();


            user.setEmail(editEmail.getText().toString());
            user.setPassword(editMdp.getText().toString());


            ApiOrange.connectUser(getActivity(), user, this);

        } else if (v.equals(buttonAccueil)) {
            listener.onSelectAccueil();
        }
    }

    @Override
    public void connect(User user) {
        if (editMdp.getText().toString().equals(user.getPassword()))
        {

        }
    }
}