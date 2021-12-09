package com.example.uno.Autres;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uno.Activity.JouerActivite;
import com.example.uno.R;

import java.util.List;

public class AdaptateurMainJoueur extends RecyclerView.Adapter<ViewHolderMainJoueur> {
    private MainJoueur mainJoueur = new MainJoueur();
    private Defausse defausse = new Defausse();

    public AdaptateurMainJoueur(List<Cartes> cartesList) {
        Log.i("Erreur", "j'y suis");
        this.mainJoueur.setMainJoueur(cartesList);
    }

    @NonNull
    @Override
    public ViewHolderMainJoueur onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i("Erreur", "j'y suis 2");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carte_uno, parent, false);
        return new ViewHolderMainJoueur(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMainJoueur holder, int position) {
        Log.i("Erreur", "J'y suis 3");
        Cartes cartes = mainJoueur.getMainJoueur().get(position);
        Cartes defausses = defausse.getDefausse().get(position);
        List<Cartes> getMainJoueur = mainJoueur.getMainJoueur();
        List<Cartes> getDefausse = defausse.getDefausse();

        Log.i("Couleur", "Nombre de carte dans la main " + getMainJoueur.size());

        holder.view.setBackgroundResource(cartes.getBackgroundCarte());

        holder.itemView.setOnClickListener(v -> {
            Couleur couleurCartes = cartes.getCouleur();
            Couleur couleurDefausse = defausses.getCouleur();

            String numeroDefausse = defausses.getNumero();
            String numeroCartes = cartes.getNumero();

            Log.i("Couleur", "Nombre de carte dans la main " + getMainJoueur.size());
            Log.i("Couleur", "Nombre de carte dans la defausse " + getDefausse.size());

            Log.i("Couleur", "Couleur carte " +couleurCartes);
            Log.i("Couleur", "Couleur defausse " + couleurDefausse);

            Log.i("Couleur", "Numero cartes " + numeroCartes);
            Log.i("Couleur", "Numero defausse " +numeroDefausse);

            if (cartes.isCarteSpe() == false) {
                Log.i("Couleur", "Je suis rentré");
                if (couleurCartes == couleurDefausse || numeroCartes == numeroDefausse) {
                    Log.i("Couleur", "Je suis bon");
                    getDefausse.add(getMainJoueur.remove(position));
                    defausse.setDefausse(getDefausse);
                    mainJoueur.setMainJoueur(getMainJoueur);
                    return;
                } else {
                    Log.i("Couleur", "Je suis pas bon");
                }
            } else {
                Log.i("Couleur", "Je suis bon");
                getDefausse.add(getMainJoueur.remove(position));
                defausse.setDefausse(getDefausse);
                mainJoueur.setMainJoueur(getMainJoueur);
            }

            Log.i("Couleur", "Nombre de carte dans la main " + getMainJoueur.size());
            Log.i("Couleur", "Nombre de carte dans la defausse " + getDefausse.size());
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
