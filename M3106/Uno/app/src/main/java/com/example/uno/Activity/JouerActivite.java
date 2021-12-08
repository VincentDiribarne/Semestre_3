package com.example.uno.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uno.Autres.AdaptateurMainJoueur;
import com.example.uno.Autres.Cartes;
import com.example.uno.Autres.Couleur;
import com.example.uno.Autres.Joueur;
import com.example.uno.Autres.NombreAleatoire;
import com.example.uno.R;

import java.util.ArrayList;
import java.util.List;

public class JouerActivite extends AppCompatActivity {
    private static List<Cartes>  paquetCartes = new ArrayList<>();
    private List<Cartes> defausse = new ArrayList<>();
    private List<Cartes> mainJoueur = new ArrayList<>();

    private TextView pseudoJoueur;
    private Button findetour;
    private ImageView pioche, defausseImageView;
    private RecyclerView recyclerView;
    private AdaptateurMainJoueur adaptateurMainJoueur;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeux);
        pseudoJoueur = findViewById(R.id.Pseudo);
        findetour = findViewById(R.id.finDeTour);
        pioche = findViewById(R.id.pioche);
        defausseImageView = findViewById(R.id.defausse);

        Intent intentRecup = getIntent();

        int intentNombre = intentRecup.getIntExtra("Position", -1);
        List<Joueur> joueursList = CreationActivity.joueurs;
        joueursList.add(new Joueur("Vincent", 0));
        joueursList.add(new Joueur("Cyrielle", 0));
        findetour.setVisibility(View.INVISIBLE);
        recyclerView = findViewById(R.id.recyclerViewCartes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        if (intentNombre == -1) {
            initList();
            for (int i = 0; i < joueursList.size(); i++) {
                mainJoueur.clear();
                for (int j = 0; j < 7; j++) {
                    mainJoueur.add(paquetCartes.remove(NombreAleatoire.getNombreRandom(paquetCartes.size(), 1)));
                }
                joueursList.get(i).setMainCartes(mainJoueur);
            }
            defausse.add(paquetCartes.remove(NombreAleatoire.getNombreRandom(paquetCartes.size(), 1)));
            Log.i("Defausse", String.valueOf(defausse.size()));
            intentNombre = 0;
            lancementTour(joueursList, intentNombre);
        } else {
            affichageTexte(joueursList, intentNombre);
            affichageCarte(joueursList, intentNombre);

            pioche.setOnClickListener(v -> {
                mainJoueur.add(paquetCartes.remove(NombreAleatoire.getNombreRandom(paquetCartes.size(), 1)));
                findetour.setVisibility(View.VISIBLE);
            });

            int finalIntentNombre = intentNombre;
            findetour.setOnClickListener(v -> lancementTour(joueursList, finalIntentNombre));
        }
    }

    private void initList() {
        paquetCartes.add(new Cartes("0", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("1", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("2", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("3", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("4", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("5", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("6", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("7", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("8", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("9", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("1", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("2", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("3", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("4", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("5", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("6", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("7", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("8", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("9", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("+2", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("+2", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("ChangeSens", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("ChangeSens", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("PasseTour", Couleur.Bleu, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("PasseTour", Couleur.Bleu, R.drawable.bleu_plus_2, false));


        paquetCartes.add(new Cartes("0", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("1", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("2", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("3", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("4", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("5", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("6", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("7", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("8", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("9", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("1", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("2", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("3", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("4", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("5", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("6", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("7", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("8", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("9", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("+2", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("+2", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("ChangeSens", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("ChangeSens", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("PasseTour", Couleur.Vert, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("PasseTour", Couleur.Vert, R.drawable.bleu_plus_2, false));


        paquetCartes.add(new Cartes("0", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("1", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("2", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("3", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("4", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("5", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("6", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("7", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("8", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("9", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("1", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("2", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("3", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("4", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("5", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("6", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("7", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("8", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("9", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("+2", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("+2", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("ChangeSens", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("ChangeSens", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("PasseTour", Couleur.Rouge, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("PasseTour", Couleur.Rouge, R.drawable.bleu_plus_2, false));


        paquetCartes.add(new Cartes("0", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("1", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("2", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("3", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("4", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("5", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("6", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("7", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("8", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("9", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("1", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("2", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("3", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("4", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("5", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("6", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("7", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("8", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("9", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("+2", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("+2", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("ChangeSens", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("ChangeSens", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("PasseTour", Couleur.Jaune, R.drawable.bleu_plus_2, false));
        paquetCartes.add(new Cartes("PasseTour", Couleur.Jaune, R.drawable.bleu_plus_2, false));

        paquetCartes.add(new Cartes("+4", Couleur.Noire, R.drawable.bleu_plus_2, true));
        paquetCartes.add(new Cartes("+4", Couleur.Noire, R.drawable.bleu_plus_2, true));
        paquetCartes.add(new Cartes("+4", Couleur.Noire, R.drawable.bleu_plus_2, true));
        paquetCartes.add(new Cartes("+4", Couleur.Noire, R.drawable.bleu_plus_2, true));

        paquetCartes.add(new Cartes("ChangeCouleur", Couleur.Noire, R.drawable.bleu_plus_2, true));
        paquetCartes.add(new Cartes("ChangeCouleur", Couleur.Noire, R.drawable.bleu_plus_2, true));
        paquetCartes.add(new Cartes("ChangeCouleur", Couleur.Noire, R.drawable.bleu_plus_2, true));
        paquetCartes.add(new Cartes("ChangeCouleur", Couleur.Noire, R.drawable.bleu_plus_2, true));
    }

    private void affichageCarte(List<Joueur> joueursList, int i) {
        List<Cartes> mainjoueur = joueursList.get(i).getMainCartes();
        defausse.add(paquetCartes.remove(NombreAleatoire.getNombreRandom(paquetCartes.size(), 1)));
        adaptateurMainJoueur = new AdaptateurMainJoueur(mainjoueur, defausse);
        recyclerView.setAdapter(adaptateurMainJoueur);
    }

    private void affichageTexte(List<Joueur> joueursList, int i) {
        pseudoJoueur.setText(joueursList.get(i).getNom());
    }

    public void lancementTour(List<Joueur> joueursList, int i) {
        setContentView(R.layout.page_noir);
        int j = i, finalJ;
        if (joueursList.size() > i) {
            j = i + 1;
        } else {
            j = 0;
        }

        finalJ = j;
        new AlertDialog.Builder(this)
                .setTitle("A qui le tour ?")
                .setMessage("C'est au tour de \"" + joueursList.get(i).getNom() + "\" de jouer")
                .setIcon(R.drawable.uno_logo)
                .setPositiveButton(R.string.commencer, (dialog, which) -> {
                    Intent intent = new Intent(this, JouerActivite.class);

                    intent.putExtra("Position", finalJ);
                    startActivity(intent);
                })
                .show();
    }
}
