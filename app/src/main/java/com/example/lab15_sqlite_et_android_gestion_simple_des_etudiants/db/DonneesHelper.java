package com.example.lab15_sqlite_et_android_gestion_simple_des_etudiants.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DonneesHelper extends SQLiteOpenHelper {

    private static final int VERSION_BD = 1;
    private static final String NOM_BD = "ecole_pro.db";

    public static final String TABLE_MEMBRES = "membres";
    public static final String COL_CLE = "clef";
    public static final String COL_NOM = "nom_famille";
    public static final String COL_PRENOM = "prenom_membre";

    private static final String SCRIPT_CREATION =
            "CREATE TABLE " + TABLE_MEMBRES + " (" +
                    COL_CLE + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_NOM + " TEXT, " +
                    COL_PRENOM + " TEXT);";

    public DonneesHelper(Context context) {
        super(context, NOM_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SCRIPT_CREATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMBRES);
        onCreate(db);
    }
}
