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
import com.example.uno.Autres.ListJoueur;
import com.example.uno.Autres.MainJoueur;
import com.example.uno.Autres.NombreAleatoire;
import com.example.uno.Autres.PaquetCartes;
import com.example.uno.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JouerActivite extends AppCompatActivity {
    private Defausse defausse = LancementPartieActivity.defausse;
    private PaquetCartes paquetCartes = LancementPartieActivity.paquetCartes;
    private List<Cartes> mainJoueur = LancementPartieActivity.mainJoueur;
    private ListJoueur joueursList;

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

        Intent intentSerializable = getIntent();
        ListJoueur intentRecupList = (ListJoueur) intentSerializable.getSerializableExtra("ListJoueur");

        joueursList = intentRecupList;

        pseudoJoueur = findViewById(R.id.Pseudo);
        findetour = findViewById(R.id.finDeTour);
        pioche = findViewById(R.id.pioche);
        defausseImageView = findViewById(R.id.defausse);
        recyclerView = findViewById(R.id.recyclerViewCartes);

        defausseImageView.setBackgroundResource(defausse.getDefausse().get(defausse.getDefausse().size() - 1).getBackgroundCarte());
        pioche.setBackgroundResource(R.drawable.choix_couleur);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        Log.i("IntentRecup", String.valueOf(intentRecup));
        Log.i("Taille Liste", String.valueOf(joueursList.getListJoueur().size()));

        Log.i("Taille de la main", String.valueOf(paquetCartes.getPaquetDeCartes().size()));

        List<Cartes> mainjoueur = joueursList.getListJoueur().get(intentRecup).getMainCartes();
        adaptateurMainJoueur = new AdaptateurMainJoueur(mainjoueur);
        recyclerView.setAdapter(adaptateurMainJoueur);

        affichageTexte(intentRecup);

        pioche.setOnClickListener(v -> {
            mainJoueur.add(paquetCartes.getPaquetDeCartes().remove((NombreAleatoire.getNombreRandom(paquetCartes.getPaquetDeCartes().size(), 1))));
        });

        findetour.setOnClickListener(v -> {
            int intentRecupFinal = intentRecup;
            lancementTour(intentRecupFinal, joueursList);
        });
    }

    private void affichageTexte(int i) {
        pseudoJoueur.setText(joueursList.getListJoueur().get(i).getNom());
    }

    public void lancementTour(int i, ListJoueur intentRecup) {
        setContentView(R.layout.page_noir);
        new AlertDialog.Builder(this)
                .setTitle("A qui le tour ?")
                .setMessage("C'est au tour de \"" + joueursList.getListJoueur().get(i + 1).getNom() + "\" de jouer")
                .setIcon(R.drawable.uno_logo)
                .setPositiveButton(R.string.commencer, (dialog, which) -> {

                    /*Intent intent = new Intent(this, JouerActivite.class);
                    int finalI = i;
                    finalI++;

                    if (finalI >= joueursList.getListJoueur().size()) {
                        finalI = 0;
                    }
                    intent.putExtra("Position", finalI);
                    intent.putExtra("ListJoueur", (Serializable) intentRecup);
                    startActivity(intent);*/
                })
                .show();
    }
}
