package com.example.orange;

import java.io.Serializable;
import java.time.LocalDate;

public class Materiel implements Serializable {
    private int id;
    private String designation;
    private String modele;
    private String marque;
    private int prix;
    private LocalDate dateAchat;
    private int idClient;

    public Materiel(){

    }

    public Materiel(int id, String designation, String modele, String marque, int prix, LocalDate dateAchat, int idClient)
    {
        this.id = id;
        this.designation = designation;
        this.modele = modele;
        this.marque = marque;
        this.prix = prix;
        this.dateAchat = dateAchat;
        this.idClient = idClient;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public LocalDate getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(LocalDate dateAchat) {
        this.dateAchat = dateAchat;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}
