package com.example.lab15_sqlite_et_android_gestion_simple_des_etudiants.models;

public class Participant {
    private int clef;
    private String nomFamille;
    private String prenomMembre;

    public Participant() {
    }

    public Participant(String nomFamille, String prenomMembre) {
        this.nomFamille = nomFamille;
        this.prenomMembre = prenomMembre;
    }

    public int getClef() {
        return clef;
    }

    public void setClef(int clef) {
        this.clef = clef;
    }

    public String getNomFamille() {
        return nomFamille;
    }

    public void setNomFamille(String nomFamille) {
        this.nomFamille = nomFamille;
    }

    public String getPrenomMembre() {
        return prenomMembre;
    }

    public void setPrenomMembre(String prenomMembre) {
        this.prenomMembre = prenomMembre;
    }
}
