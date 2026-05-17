package com.example.lab15_sqlite_et_android_gestion_simple_des_etudiants.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.lab15_sqlite_et_android_gestion_simple_des_etudiants.db.DonneesHelper;
import com.example.lab15_sqlite_et_android_gestion_simple_des_etudiants.models.Participant;

import java.util.ArrayList;
import java.util.List;

public class ParticipantService {

    private final DonneesHelper dbHelper;

    public ParticipantService(Context context) {
        this.dbHelper = new DonneesHelper(context);
    }

    public void enregistrer(Participant p) {
        SQLiteDatabase db = this.dbHelper.getWritableDatabase();
        ContentValues valeurs = new ContentValues();
        valeurs.put(DonneesHelper.COL_NOM, p.getNomFamille());
        valeurs.put(DonneesHelper.COL_PRENOM, p.getPrenomMembre());

        db.insert(DonneesHelper.TABLE_MEMBRES, null, valeurs);
        Log.i("SERVICE", "Enregistrement de : " + p.getNomFamille());
        db.close();
    }

    public void miseAJour(Participant p) {
        SQLiteDatabase db = this.dbHelper.getWritableDatabase();
        ContentValues valeurs = new ContentValues();
        valeurs.put(DonneesHelper.COL_NOM, p.getNomFamille());
        valeurs.put(DonneesHelper.COL_PRENOM, p.getPrenomMembre());

        db.update(DonneesHelper.TABLE_MEMBRES, valeurs, DonneesHelper.COL_CLE + " = ?", new String[]{String.valueOf(p.getClef())});
        db.close();
    }

    public Participant trouverParClef(int clef) {
        Participant p = null;
        SQLiteDatabase db = this.dbHelper.getReadableDatabase();

        Cursor curseur = db.query(
                DonneesHelper.TABLE_MEMBRES,
                new String[]{DonneesHelper.COL_CLE, DonneesHelper.COL_NOM, DonneesHelper.COL_PRENOM},
                DonneesHelper.COL_CLE + " = ?",
                new String[]{String.valueOf(clef)},
                null, null, null
        );

        if (curseur.moveToFirst()) {
            p = new Participant();
            p.setClef(curseur.getInt(0));
            p.setNomFamille(curseur.getString(1));
            p.setPrenomMembre(curseur.getString(2));
        }

        curseur.close();
        db.close();
        return p;
    }

    public void supprimer(Participant p) {
        SQLiteDatabase db = this.dbHelper.getWritableDatabase();
        db.delete(DonneesHelper.TABLE_MEMBRES, DonneesHelper.COL_CLE + " = ?", new String[]{String.valueOf(p.getClef())});
        db.close();
    }

    public List<Participant> recupererTous() {
        List<Participant> liste = new ArrayList<>();
        SQLiteDatabase db = this.dbHelper.getReadableDatabase();
        Cursor curseur = db.rawQuery("SELECT * FROM " + DonneesHelper.TABLE_MEMBRES, null);

        if (curseur.moveToFirst()) {
            do {
                Participant p = new Participant();
                p.setClef(curseur.getInt(0));
                p.setNomFamille(curseur.getString(1));
                p.setPrenomMembre(curseur.getString(2));
                liste.add(p);
            } while (curseur.moveToNext());
        }

        curseur.close();
        db.close();
        return liste;
    }
}
