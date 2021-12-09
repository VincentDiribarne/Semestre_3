package com.example.uno.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uno.Autres.AdaptateurMainJoueur;
import com.example.uno.Autres.Cartes;
import com.example.uno.Autres.Defausse;
import com.example.uno.Autres.Joueur;
import com.example.uno.Autres.NombreAleatoire;
import com.example.uno.Autres.PaquetCartes;
import com.example.uno.R;

import java.util.List;

public class JouerActivite extends AppCompatActivity {
    private Defausse defausse = LancementPartieActivity.defausse;
    private PaquetCartes paquetCartes = LancementPartieActivity.paquetCartes;
    private List<Cartes> mainJoueur;
    private List<Joueur> joueursList = CreationActivity.joueurList;

    private TextView pseudoJoueur;
    private Button findetour;
    private ImageView pioche, defausseImageView;
    private RecyclerView recyclerView;
    private AdaptateurMainJoueur adaptateurMainJoueur;

    public int i = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeux);

        lancementTour();
    }

    private void affichageTexte(int i) {
        pseudoJoueur.setText(joueursList.get(i).getNom());
    }

    public void pioche() {
        pioche.setOnClickListener(v -> {
            mainJoueur.add(paquetCartes.getPaquetDeCartes().remove((NombreAleatoire.getNombreRandom(paquetCartes.getPaquetDeCartes().size(), 1))));
            adaptateurMainJoueur.notifyItemInserted(mainJoueur.size());
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    private void changementDeJoueur() {
        setContentView(R.layout.activity_jeux);

        pseudoJoueur = findViewById(R.id.Pseudo);
        findetour = findViewById(R.id.finDeTour);
        pioche = findViewById(R.id.pioche);
        defausseImageView = findViewById(R.id.defausse);
        recyclerView = findViewById(R.id.recyclerViewCartes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        mainJoueur = joueursList.get(i).getMainCartes();
        adaptateurMainJoueur = new AdaptateurMainJoueur(mainJoueur);
        recyclerView.setAdapter(adaptateurMainJoueur);

        affichageTexte(i);
        defausseImageView.setBackgroundResource(defausse.getDefausse().get(defausse.getDefausse().size() - 1).getBackgroundCarte());
        pioche.setBackgroundResource(R.drawable.choix_couleur);

        pioche();

        //victoire();
        i++;
        if (i >= joueursList.size()) {
            i = 0;
        }
        findetour();
    }

    private void findetour() {
        findetour.setOnClickListener(v -> {
            lancementTour();
        });
    }

    public void lancementTour() {
        setContentView(R.layout.page_noir);
        new AlertDialog.Builder(this)
                .setTitle("A qui le tour ?")
                .setMessage("C'est au tour de \"" + joueursList.get(i).getNom() + "\" de jouer")
                .setIcon(R.drawable.uno_logo)
                .setPositiveButton(R.string.commencer, (dialog, which) -> {
                    changementDeJoueur();
                })
                .show();
    }


}
