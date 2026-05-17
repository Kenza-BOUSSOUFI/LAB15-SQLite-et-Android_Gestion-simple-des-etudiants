package com.example.lab15_sqlite_et_android_gestion_simple_des_etudiants.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDonneeHelper extends SQLiteOpenHelper {

    private static final int VERSION_BD = 1;
    private static final String NOM_BD = "gestion_ecole.db";

    public static final String TABLE_APPRENANT = "apprenant";
    public static final String COL_ID = "id";
    public static final String COL_NOM = "nom";
    public static final String COL_PRENOM = "prenom";

    private static final String REQUETE_CREATION_TABLE =
            "CREATE TABLE " + TABLE_APPRENANT + " (" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_NOM + " TEXT, " +
                    COL_PRENOM + " TEXT);";

    public BaseDonneeHelper(Context context) {
        super(context, NOM_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(REQUETE_CREATION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_APPRENANT);
        onCreate(db);
    }
}
