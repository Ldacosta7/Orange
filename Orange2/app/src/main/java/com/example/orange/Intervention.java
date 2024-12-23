package com.example.orange;

import java.io.Serializable;
import java.time.LocalDate;

public class Intervention implements Serializable {

    private int id;
    private LocalDate dateIntervention;
    private String description;
    private int duree;
    private String statut;
    private int prix;
    private int idClient;

    public Intervention(){

    }

    public Intervention(int id, LocalDate dateIntervention, String description, int duree, String statut, int prix, int idClient)
    {
        this.id = id;
        this.dateIntervention = dateIntervention;
        this.description = description;
        this.duree = duree;
        this.statut = statut;
        this.prix = prix;
        this.idClient = idClient;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateIntervention() {
        return dateIntervention;
    }

    public void setDateIntervention(LocalDate dateIntervention) {
        this.dateIntervention = dateIntervention;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}
