package com.example.orange;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.rxjava2.RxPreferenceDataStoreBuilder;
import androidx.datastore.rxjava2.RxDataStore;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements ISelectButtonHomePage{

    private homepage fragmentHomePage ;
    private forminscription fragmentFormInscription;
    private formintervention fragmentFormIntervention;
    private formmateriel fragmentFormmateriel;
    private connexion fragmentConnexion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentHomePage = new homepage();
        fragmentHomePage.setListener(this);
        fragmentFormInscription = new forminscription();
        fragmentFormInscription.setListener(this);
        fragmentFormIntervention = new formintervention();
        fragmentFormIntervention.setListener(this);
        fragmentFormmateriel = new formmateriel();
        fragmentFormmateriel.setListener(this);
        fragmentConnexion = new connexion();
        fragmentConnexion.setListener(this);



        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayout, fragmentHomePage)
                .add(R.id.frameLayout, fragmentFormInscription)
                .add(R.id.frameLayout, fragmentFormIntervention)
                .add(R.id.frameLayout, fragmentFormmateriel)
                .add(R.id.frameLayout, fragmentConnexion)
                .hide(fragmentFormInscription)
                .hide(fragmentFormmateriel)
                .hide(fragmentFormIntervention)
                .hide(fragmentConnexion)
                .commit();

        RxDataStore<Preferences> dataStore = new RxPreferenceDataStoreBuilder(this, "dataStore").build();

    }

    @Override
    public void onSelectMaterielAjout() {
        getSupportFragmentManager().beginTransaction()
                .hide(fragmentHomePage)
                .show(fragmentFormmateriel)
                .commit();
    }

    @Override
    public void onSelectInterventionsAjout() {
        getSupportFragmentManager().beginTransaction()
                .hide(fragmentHomePage)
                .show(fragmentFormIntervention)
                .commit();
    }

    @Override
    public void onSelectInscription() {
        getSupportFragmentManager().beginTransaction()
                .hide(fragmentHomePage)
                .show(fragmentFormInscription)
                .commit();
    }

    @Override
    public void onSelectConnexion() {
        getSupportFragmentManager().beginTransaction()
                .hide(fragmentHomePage)
                .show(fragmentConnexion)
                .commit();
    }

    @Override
    public void onSelectMaterielAffichage() {

    }

    @Override
    public void onSelectInterventionAffichage() {

    }

    @Override
    public void onSelectAccueil() {
        getSupportFragmentManager().beginTransaction()
                .hide(fragmentFormInscription)
                .hide(fragmentFormmateriel)
                .hide(fragmentFormIntervention)
                .hide(fragmentConnexion)
                .show(fragmentHomePage)
                .commit();
    }

    @Override
    public void onAjoutUser() {
        getSupportFragmentManager().beginTransaction()
                .hide(fragmentHomePage)
                .show(fragmentFormInscription)
                .commit();
    }
}