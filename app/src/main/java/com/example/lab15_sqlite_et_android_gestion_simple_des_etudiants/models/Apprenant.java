package com.example.lab15_sqlite_et_android_gestion_simple_des_etudiants.models;

public class Apprenant {
    private int codeInterne;
    private String nomFamille;
    private String prenomUsage;

    public Apprenant() {
    }

    public Apprenant(String nomFamille, String prenomUsage) {
        this.nomFamille = nomFamille;
        this.prenomUsage = prenomUsage;
    }

    public int getCodeInterne() {
        return codeInterne;
    }

    public void setCodeInterne(int codeInterne) {
        this.codeInterne = codeInterne;
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
