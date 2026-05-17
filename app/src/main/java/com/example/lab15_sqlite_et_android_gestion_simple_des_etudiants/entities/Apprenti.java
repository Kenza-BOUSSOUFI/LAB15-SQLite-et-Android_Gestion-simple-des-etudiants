package com.example.lab15_sqlite_et_android_gestion_simple_des_etudiants.entities;

public class Apprenti {
    private int codeId;
    private String nomFamille;
    private String prenomUsage;

    public Apprenti() {
    }

    public Apprenti(String nomFamille, String prenomUsage) {
        this.nomFamille = nomFamille;
        this.prenomUsage = prenomUsage;
    }

    public int getCodeId() {
        return codeId;
    }

    public void setCodeId(int codeId) {
        this.codeId = codeId;
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
