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
import com.example.uno.Autres.Defausse;
import com.example.uno.Autres.Joueur;
import com.example.uno.Autres.MainJoueur;
import com.example.uno.Autres.NombreAleatoire;
import com.example.uno.Autres.PaquetCartes;
import com.example.uno.R;

import java.util.ArrayList;
import java.util.List;

public class JouerActivite extends AppCompatActivity {
    private Defausse defausse = LancementPartieActivity.defausse;
    private PaquetCartes paquetCartes = LancementPartieActivity.paquetCartes;
    private List<Cartes> mainJoueur = LancementPartieActivity.mainJoueur;
    private List<Joueur> joueursList = CreationActivity.joueurs;

    private TextView pseudoJoueur;
    private Button findetour;
    private ImageView pioche, defausseImageView;
    private RecyclerView recyclerView;
    private AdaptateurMainJoueur adaptateurMainJoueur;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeux);

        Intent intent = getIntent();
        int intentRecup = intent.getIntExtra("Position", 0);

        pseudoJoueur = findViewById(R.id.Pseudo);
        findetour = findViewById(R.id.finDeTour);
        pioche = findViewById(R.id.pioche);
        defausseImageView = findViewById(R.id.defausse);
        recyclerView = findViewById(R.id.recyclerViewCartes);


        Log.e("Erreur", String.valueOf(defausse.getDefausse().size()));
        defausseImageView.setBackgroundResource(defausse.getDefausse().get(defausse.getDefausse().size() - 1).getBackgroundCarte());
        pioche.setBackgroundResource(R.drawable.choix_couleur);

        Log.e("Erreur", "Intent --> " +intentRecup);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        affichageCarte(intentRecup);
        affichageTexte(intentRecup);

        pioche.setOnClickListener(v -> {
            mainJoueur.add(paquetCartes.getPaquetDeCartes().remove((NombreAleatoire.getNombreRandom(paquetCartes.getPaquetDeCartes().size(), 1))));
        });

        findetour.setOnClickListener(v -> {
            int intentRecupFinal = intentRecup;
            lancementTour(intentRecupFinal++);
        });
    }

    private void affichageCarte(int i) {
        Log.i("Erreur", "Je suis rentré dans l'adaptateur");
        List<Cartes> mainjoueur = joueursList.get(i).getMainCartes();
        Log.i("Erreur", "Main du joueur " + mainjoueur.size());
        adaptateurMainJoueur = new AdaptateurMainJoueur(mainjoueur);
        recyclerView.setAdapter(adaptateurMainJoueur);
    }

    private void affichageTexte(int i) {
        pseudoJoueur.setText(joueursList.get(i).getNom());
    }

    public void lancementTour(int i) {
        setContentView(R.layout.page_noir);
        new AlertDialog.Builder(this)
                .setTitle("A qui le tour ?")
                .setMessage("C'est au tour de \"" + joueursList.get(i+1).getNom() + "\" de jouer")
                .setIcon(R.drawable.uno_logo)
                .setPositiveButton(R.string.commencer, (dialog, which) -> {
                    Intent intent = new Intent(this, JouerActivite.class);
                    int j = i;
                    j++;

                    if (j > joueursList.size()) {
                        j = 0;
                    }
                    intent.putExtra("Position", j);
                    startActivity(intent);
                })
                .show();
    }
}
