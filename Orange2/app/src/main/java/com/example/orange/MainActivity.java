package com.example.orange;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.rxjava2.RxPreferenceDataStoreBuilder;
import androidx.datastore.rxjava2.RxDataStore;

public class MainActivity extends AppCompatActivity implements ISelectButtonHomePage{

    private homepage fragmentHomePage ;
    private forminscription fragmentFormInscription;
    private formintervention fragmentFormIntervention;
    private formmateriel fragmentFormmateriel;
    private connexion fragmentConnexion;
    private FragmentIntervention fragmentIntervention;
    private FragmentMateriel fragmentMateriel;




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
        fragmentIntervention = new FragmentIntervention();
        fragmentIntervention.setListener(this);
        fragmentMateriel = new FragmentMateriel();
        fragmentMateriel.setListener(this);




        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayout, fragmentHomePage)
                .add(R.id.frameLayout, fragmentFormInscription)
                .add(R.id.frameLayout, fragmentFormIntervention)
                .add(R.id.frameLayout, fragmentFormmateriel)
                .add(R.id.frameLayout, fragmentConnexion)
                .add(R.id.frameLayout, fragmentIntervention)
                .add(R.id.frameLayout, fragmentMateriel)
                .hide(fragmentFormInscription)
                .hide(fragmentFormmateriel)
                .hide(fragmentFormIntervention)
                .hide(fragmentConnexion)
                .hide(fragmentIntervention)
                .hide(fragmentMateriel)
                .commit();



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
        getSupportFragmentManager().beginTransaction()
                .hide(fragmentHomePage)
                .show(fragmentMateriel)
                .commit();
    }

    @Override
    public void onSelectInterventionAffichage() {
        getSupportFragmentManager().beginTransaction()
                .hide(fragmentHomePage)
                .show(fragmentIntervention)
                .commit();
    }

    @Override
    public void onSelectAccueil() {
        getSupportFragmentManager().beginTransaction()
                .hide(fragmentFormInscription)
                .hide(fragmentFormmateriel)
                .hide(fragmentFormIntervention)
                .hide(fragmentConnexion)
                .hide(fragmentIntervention)
                .hide(fragmentMateriel)
                .show(fragmentHomePage)
                .commit();
    }

    @Override
    public void onSelectDeconnexion() {
        this.onSelectAccueil();
    }

    @Override
    public void onAjoutUser() {
        getSupportFragmentManager().beginTransaction()
                .hide(fragmentHomePage)
                .show(fragmentFormInscription)
                .commit();
    }
}