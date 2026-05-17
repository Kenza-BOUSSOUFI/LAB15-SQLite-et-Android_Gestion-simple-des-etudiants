package com.example.lab15_sqlite_et_android_gestion_simple_des_etudiants.models;

public class Inscrit {
    private int identifiant;
    private String nomFamille;
    private String prenomUsage;

    public Inscrit() { }

    public Inscrit(String nomFamille, String prenomUsage) {
        this.nomFamille = nomFamille;
        this.prenomUsage = prenomUsage;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getNomFamille() {
        return nomFamille;
    }

    public void setNomFamille(String nomFamille) {
        this.nomFamille = nomFamille;
    }

    public String getPrenomUsage() {
        return prenomUsage;
    }

    public void setPrenomUsage(String prenomUsage) {
        this.prenomUsage = prenomUsage;
    }
}
