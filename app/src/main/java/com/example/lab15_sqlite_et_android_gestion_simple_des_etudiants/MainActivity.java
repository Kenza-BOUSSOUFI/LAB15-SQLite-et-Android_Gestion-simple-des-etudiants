package com.example.lab15_sqlite_et_android_gestion_simple_des_etudiants;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab15_sqlite_et_android_gestion_simple_des_etudiants.models.Apprenant;
import com.example.lab15_sqlite_et_android_gestion_simple_des_etudiants.services.ApprenantService;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText champNom, champPrenom, champIdCible;
    private Button boutonEnregistrer, boutonTrouver, boutonRetirer;
    private TextView labelResultat;
    private ApprenantService gestionnaire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Gestion des Insets pour le design Edge-to-Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialisation du service
        gestionnaire = new ApprenantService(this);

        // Liaison des composants UI
        champNom = findViewById(R.id.edit_nom_famille);
        champPrenom = findViewById(R.id.edit_prenom_apprenant);
        champIdCible = findViewById(R.id.edit_recherche_id);
        
        boutonEnregistrer = findViewById(R.id.btn_enregistrer);
        boutonTrouver = findViewById(R.id.btn_trouver);
        boutonRetirer = findViewById(R.id.btn_retirer);
        
        labelResultat = findViewById(R.id.txt_affichage_resultat);

        // --- Action : AJOUTER ---
        boutonEnregistrer.setOnClickListener(v -> {
            String nom = champNom.getText().toString().trim();
            String prenom = champPrenom.getText().toString().trim();

            if (!nom.isEmpty() && !prenom.isEmpty()) {
                Apprenant nouveau = new Apprenant(nom, prenom);
                gestionnaire.ajouter(nouveau);
                
                nettoyerZonesSaisie();
                loggerEtatBase();
                Toast.makeText(this, "Apprenant bien enregistré !", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Champs obligatoires non remplis", Toast.LENGTH_SHORT).show();
            }
        });

        // --- Action : TROUVER ---
        boutonTrouver.setOnClickListener(v -> {
            String idStr = champIdCible.getText().toString().trim();
            if (idStr.isEmpty()) {
                Toast.makeText(this, "Précisez un identifiant", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int id = Integer.parseInt(idStr);
                Apprenant a = gestionnaire.rechercherParId(id);

                if (a != null) {
                    labelResultat.setText(String.format("%s %s", a.getNomFamille(), a.getPrenomUsage()));
                } else {
                    labelResultat.setText("");
                    Toast.makeText(this, "Aucun enregistrement trouvé", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Format ID invalide", Toast.LENGTH_SHORT).show();
            }
        });

        // --- Action : SUPPRIMER ---
        boutonRetirer.setOnClickListener(v -> {
            String idStr = champIdCible.getText().toString().trim();
            if (idStr.isEmpty()) return;

            try {
                int id = Integer.parseInt(idStr);
                Apprenant cible = gestionnaire.rechercherParId(id);

                if (cible != null) {
                    gestionnaire.retirer(cible);
                    labelResultat.setText("");
                    champIdCible.setText("");
                    loggerEtatBase();
                    Toast.makeText(this, "Apprenant retiré avec succès", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "ID inexistant", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Format ID invalide", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void nettoyerZonesSaisie() {
        champNom.setText("");
        champPrenom.setText("");
    }

    private void loggerEtatBase() {
        List<Apprenant> liste = gestionnaire.recupererTous();
        Log.i("APP_DB_TRACE", "--- Liste des inscrits ---");
        for (Apprenant a : liste) {
            Log.i("APP_DB_TRACE", String.format("Ref: %d | Nom: %s %s", a.getCodeInterne(), a.getNomFamille(), a.getPrenomUsage()));
        }
    }
}
