package com.example.uno.Autres;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uno.Activity.FinActivity;
import com.example.uno.Activity.MainActivity;
import com.example.uno.R;

import java.util.List;

public class AdaptateurMainJoueur extends RecyclerView.Adapter<ViewHolderMainJoueur> {
    public List<Cartes> mainJoueur;
    private List<Cartes> defausse;

    public AdaptateurMainJoueur(List<Cartes> cartesList, List<Cartes> defausse) {
        this.mainJoueur = cartesList;
        this.defausse = defausse;
    }

    @NonNull
    @Override
    public ViewHolderMainJoueur onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carte_uno, parent, false);
        return new ViewHolderMainJoueur(v);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolderMainJoueur holder, int position) {
        Cartes cartes = mainJoueur.get(position);
        Cartes defausses = defausse.get(defausse.size() - 1);
        holder.view.setBackgroundResource(R.drawable.background_noir);

        holder.itemView.setOnClickListener(v -> {
            Couleur couleurCartes = cartes.getCouleur();
            Couleur couleurDefausse = defausses.getCouleur();

            String numeroDefausse = defausses.getNumero();
            String numeroCartes = cartes.getNumero();

            if (cartes.getCarteSpe() != 1) {
                if (couleurCartes != couleurDefausse || numeroCartes != numeroDefausse) {
                    return;
                }
            }

            defausse.add(mainJoueur.remove(position));
        });
    }

    @Override
    public int getItemCount() {
        return mainJoueur.size();
    }
}
