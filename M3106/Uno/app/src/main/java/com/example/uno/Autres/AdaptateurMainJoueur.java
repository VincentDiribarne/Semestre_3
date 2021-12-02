package com.example.uno.Autres;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uno.R;

import java.util.List;

public class AdaptateurMainJoueur extends RecyclerView.Adapter<ViewHolderMainJoueur> {
    public List<Cartes> mainJoueur;

    public AdaptateurMainJoueur(List<Cartes> cartesList) {
        this.mainJoueur = cartesList;
    }

    @NonNull
    @Override
    public ViewHolderMainJoueur onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carte_uno, parent, false);
        return new ViewHolderMainJoueur(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMainJoueur holder, int position) {
        Cartes cartes = mainJoueur.get(position);
        holder.view.setBackgroundColor(backgroundCouleur(cartes));

        if (cartes.getCarteSpe() != 0) {
            holder.imageView.setImageResource(cartes.getCarteSpe());
        } else {
            holder.text1.setText(cartes.getNumero());
            holder.text2.setText(cartes.getNumero());
            holder.text3.setText(cartes.getNumero());
        }
    }

    private int backgroundCouleur(Cartes cartes) {
        int color = R.color.white;

        switch (cartes.getCouleur()) {
            case Jaune:
                color = R.color.jauneUno;
                break;

            case Bleu:
                color = R.color.bleuUno;
                break;

            case Vert:
                color = R.color.vertUno;
                break;

            case Noire:
                color = R.color.noirUno;
                break;

            case Rouge:
                color = R.color.redUno;
                break;
        }

        return color;
    }

    @Override
    public int getItemCount() {
        return mainJoueur.size();
    }
}
