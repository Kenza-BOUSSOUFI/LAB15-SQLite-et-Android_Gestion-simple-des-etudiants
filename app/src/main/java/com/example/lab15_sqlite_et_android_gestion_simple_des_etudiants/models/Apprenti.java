package com.example.lab15_sqlite_et_android_gestion_simple_des_etudiants.models;

public class Apprenti {
    private int matricule;
    private String nomFamille;
    private String prenomUsage;

    public Apprenti() {
    }

    public Apprenti(String nomFamille, String prenomUsage) {
        this.nomFamille = nomFamille;
        this.prenomUsage = prenomUsage;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
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
