package com.example.lab15_sqlite_et_android_gestion_simple_des_etudiants.entities;

public class Eleve {
    private int idRef;
    private String nomFamille;
    private String prenomEleve;

    public Eleve() {
    }

    public Eleve(String nomFamille, String prenomEleve) {
        this.nomFamille = nomFamille;
        this.prenomEleve = prenomEleve;
    }

    public int getIdRef() {
        return idRef;
    }

    public void setIdRef(int idRef) {
        this.idRef = idRef;
    }

    public String getNomFamille() {
        return nomFamille;
    }

    public void setNomFamille(String nomFamille) {
        this.nomFamille = nomFamille;
    }

    public String getPrenomEleve() {
        return prenomEleve;
    }

    public void setPrenomEleve(String prenomEleve) {
        this.prenomEleve = prenomEleve;
    }
}
