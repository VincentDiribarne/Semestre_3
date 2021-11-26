package com.example.uno.Activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uno.Autres.AdapteurJoueur;
import com.example.uno.Autres.Joueur;
import com.example.uno.R;

import java.util.ArrayList;
import java.util.List;

public class CreationActivity extends AppCompatActivity {
    private ImageView ajout;
    private TextView pseudo;
    private RecyclerView recyclerView;
    public static List<Joueur> joueurs = new ArrayList<>();
    private AdapteurJoueur adapteurJoueur;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);

        ajout = findViewById(R.id.ajout);
        pseudo = findViewById(R.id.pseudoEditText);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapteurJoueur = new AdapteurJoueur<>(joueurs);
        recyclerView.setAdapter(adapteurJoueur);

        ajout.setOnClickListener(v -> ajout());
    }

    public void ajout() {
        String pseudoText = pseudo.getText().toString();
        if (pseudoText.isEmpty()) {
            pseudo.setError("Entrez un pseudo");
            return;
        }

        joueurs.add(new Joueur(pseudoText));
        pseudo.setText("");
        Log.i("ListeJoueur", joueurs.toString());
        adapteurJoueur.notifyItemInserted(joueurs.size()+1);
    }
}
