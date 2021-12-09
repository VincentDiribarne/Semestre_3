package com.example.uno.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uno.Autres.Cartes;
import com.example.uno.Autres.Defausse;
import com.example.uno.Autres.Joueur;
import com.example.uno.Autres.ListJoueur;
import com.example.uno.Autres.NombreAleatoire;
import com.example.uno.Autres.PaquetCartes;
import com.example.uno.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LancementPartieActivity extends AppCompatActivity {
    public static PaquetCartes paquetCartes = new PaquetCartes();
    public static Defausse defausse = new Defausse();
    public static List<Cartes> mainJoueur = new ArrayList<>();
    private List<Joueur> joueursList = ListJoueur.listJoueur;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (int i = 0; i < joueursList.size(); i++) {
            Log.i("Taille de la main", i + " - " + paquetCartes.getPaquetDeCartes().size());
            mainJoueur.clear();
            for (int j = 0; j < 7; j++) {
                mainJoueur.add(paquetCartes.getPaquetDeCartes().remove(NombreAleatoire.getNombreRandom(paquetCartes.getPaquetDeCartes().size() - 1, 1)));
            }
            joueursList.get(i).setMainCartes(mainJoueur);
        }

        defausse.getDefausse().add(paquetCartes.getPaquetDeCartes().remove(NombreAleatoire.getNombreRandom(paquetCartes.getPaquetDeCartes().size(), 1)));

        Intent intent = getIntent();
        ListJoueur intentRecup = (ListJoueur) intent.getSerializableExtra("ListJoueur");

        Intent newIntent = new Intent(this, JouerActivite.class);
        newIntent.putExtra("ListJoueur", (Serializable) intentRecup);
        startActivity(newIntent);
    }
}
