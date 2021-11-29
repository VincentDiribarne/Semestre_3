package com.example.uno.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uno.Autres.Cartes;
import com.example.uno.Autres.Joueur;
import com.example.uno.R;

import java.util.ArrayList;
import java.util.List;

public class JouerActivite extends AppCompatActivity {
    private List<Cartes> paquetCartes = new ArrayList<>();
    private List<Cartes> defausse = new ArrayList<>();
    private List<Cartes> mainJoueur;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intentRecup = getIntent();
        int intentNombre = intentRecup.getIntExtra("Position", -1);
        List<Joueur> joueursList = CreationActivity.joueurs;
        if (intentNombre == -1) {
            initList();
        }
        lancementTour(joueursList, intentNombre);
    }

    private void initList() {

    }

    public void lancementTour(List<Joueur> joueursList, int i) {
        setContentView(R.layout.page_noir);
        new AlertDialog.Builder(this)
                .setTitle("A qui le tour ?")
                .setMessage("C'est au tour de \"" + joueursList.get(i).getNom() + "\" de jouer")
                .setIcon(R.drawable.uno_logo)
                .setPositiveButton(R.string.compris, (dialog, which) -> {
                    Intent intent = new Intent(this, JouerActivite.class);
                    int j;
                    if (joueursList.size() > i) {
                        j = i + 1;
                    } else {
                        j = 0;
                    }
                    intent.putExtra("Position", j);
                    startActivity(intent);
                })
                .show();
    }
}
