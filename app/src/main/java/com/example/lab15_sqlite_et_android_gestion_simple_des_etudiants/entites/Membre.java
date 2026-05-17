package com.example.lab15_sqlite_et_android_gestion_simple_des_etudiants.entites;

public class Membre {
    private int code;
    private String nomMembre;
    private String prenomMembre;

    public Membre() { }

    public Membre(String nomMembre, String prenomMembre) {
        this.nomMembre = nomMembre;
        this.prenomMembre = prenomMembre;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public String getPrenomMembre() {
        return prenomMembre;
    }

    public void setPrenomMembre(String prenomMembre) {
        this.prenomMembre = prenomMembre;
    }
}
