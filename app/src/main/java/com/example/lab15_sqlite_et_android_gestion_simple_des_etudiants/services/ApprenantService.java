package com.example.lab15_sqlite_et_android_gestion_simple_des_etudiants.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.example.lab15_sqlite_et_android_gestion_simple_des_etudiants.models.Apprenant;
import com.example.lab15_sqlite_et_android_gestion_simple_des_etudiants.database.BaseDonneeHelper;

public class ApprenantService {

    private final BaseDonneeHelper dbHelper;
    private static final String TAG = "ApprenantService";

    public ApprenantService(Context context) {
        this.dbHelper = new BaseDonneeHelper(context);
    }

    public void ajouter(Apprenant a) {
        SQLiteDatabase db = this.dbHelper.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put(BaseDonneeHelper.COL_NOM, a.getNomFamille());
        v.put(BaseDonneeHelper.COL_PRENOM, a.getPrenomUsage());

        db.insert(BaseDonneeHelper.TABLE_APPRENANT, null, v);
        Log.d(TAG, "Ajout de : " + a.getNomFamille());
        db.close();
    }

    public void mettreAJour(Apprenant a) {
        SQLiteDatabase db = this.dbHelper.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put(BaseDonneeHelper.COL_NOM, a.getNomFamille());
        v.put(BaseDonneeHelper.COL_PRENOM, a.getPrenomUsage());

        db.update(BaseDonneeHelper.TABLE_APPRENANT, v, BaseDonneeHelper.COL_ID + " = ?", new String[]{String.valueOf(a.getCodeInterne())});
        db.close();
    }

    public Apprenant rechercherParId(int id) {
        Apprenant a = null;
        SQLiteDatabase db = this.dbHelper.getReadableDatabase();

        Cursor cursor = db.query(
                BaseDonneeHelper.TABLE_APPRENANT,
                new String[]{BaseDonneeHelper.COL_ID, BaseDonneeHelper.COL_NOM, BaseDonneeHelper.COL_PRENOM},
                BaseDonneeHelper.COL_ID + " = ?",
                new String[]{String.valueOf(id)},
                null, null, null
        );

        if (cursor.moveToFirst()) {
            a = new Apprenant();
            a.setCodeInterne(cursor.getInt(0));
            a.setNomFamille(cursor.getString(1));
            a.setPrenomUsage(cursor.getString(2));
        }

        cursor.close();
        db.close();
        return a;
    }

    public void retirer(Apprenant a) {
        SQLiteDatabase db = this.dbHelper.getWritableDatabase();
        db.delete(BaseDonneeHelper.TABLE_APPRENANT, BaseDonneeHelper.COL_ID + " = ?", new String[]{String.valueOf(a.getCodeInterne())});
        db.close();
    }

    public List<Apprenant> recupererTous() {
        List<Apprenant> liste = new ArrayList<>();
        SQLiteDatabase db = this.dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + BaseDonneeHelper.TABLE_APPRENANT, null);

        if (cursor.moveToFirst()) {
            do {
                Apprenant a = new Apprenant();
                a.setCodeInterne(cursor.getInt(0));
                a.setNomFamille(cursor.getString(1));
                a.setPrenomUsage(cursor.getString(2));
                liste.add(a);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return liste;
    }
}
