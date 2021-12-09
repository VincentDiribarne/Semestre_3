package com.example.uno.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uno.Autres.AdapteurJoueur;
import com.example.uno.Autres.Joueur;
import com.example.uno.Autres.ListJoueur;
import com.example.uno.R;

import java.util.ArrayList;
import java.util.List;

public class CreationActivity extends AppCompatActivity {
    private TextView pseudo;
    private Button valider;
    private RecyclerView recyclerView;
    public ListJoueur joueurs = new ListJoueur();
    public List<Joueur> joueurList = new ArrayList<>();
    private AdapteurJoueur adapteurJoueur;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);

        ImageView ajout = findViewById(R.id.ajout);
        pseudo = findViewById(R.id.pseudoEditText);
        valider = findViewById(R.id.jouer);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapteurJoueur = new AdapteurJoueur(joueurList);
        recyclerView.setAdapter(adapteurJoueur);

        interaction();
        ajout.setOnClickListener(v -> ajout());

        valider.setOnClickListener(v -> {
            joueurs.setListJoueur(joueurList);

            Intent intent = new Intent(this, LancementPartieActivity.class);
            intent.putExtra("ListJoueur", joueurs);
            startActivity(intent);
        });
    }

    public void interaction() {
        ItemTouchHelper.SimpleCallback ith = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int pos = viewHolder.getAdapterPosition();
                joueurList.remove(pos);
                adapteurJoueur.notifyItemRemoved(pos);

                if (joueurList.size() > 1) {
                    valider.setVisibility(View.VISIBLE);
                } else {
                    valider.setVisibility(View.INVISIBLE);
                }
            }
        };

        ItemTouchHelper helper = new ItemTouchHelper(ith);
        helper.attachToRecyclerView(recyclerView);
    }

    public void ajout() {
        String pseudoText = pseudo.getText().toString();
        if (pseudoText.isEmpty()) {
            pseudo.setError("Entrez un pseudo");
            return;
        }

        if(pseudoText.length() > 30) {
            pseudo.setError("Trop long, 30 caractères max");
            pseudo.setText("");
            return;
        }

        joueurList.add(new Joueur(pseudoText, 0));
        pseudo.setText("");
        adapteurJoueur.notifyItemInserted(joueurList.size() + 1);
        //TODO Met automatiquement en bas quand le joueur ajoute un message (TD2)

        if (joueurList.size() > 1) {
            valider.setVisibility(View.VISIBLE);
        }
    }
}
