package com.example.uno.Autres;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uno.Activity.LancementPartieActivity;
import com.example.uno.R;

import java.util.List;

public class AdaptateurMainJoueur extends RecyclerView.Adapter<ViewHolderMainJoueur> {
    private MainJoueur mainJoueur = new MainJoueur();
    private Defausse defausse = LancementPartieActivity.defausse;

    public AdaptateurMainJoueur(List<Cartes> cartesList) {
        this.mainJoueur.setMainJoueur(cartesList);
    }

    @NonNull
    @Override
    public ViewHolderMainJoueur onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carte_uno, parent, false);
        return new ViewHolderMainJoueur(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMainJoueur holder, int position) {
        holder.view.setBackgroundResource(mainJoueur.getMainJoueur().get(position).getBackgroundCarte());

        Cartes cartes = mainJoueur.getMainJoueur().get(position);

        List<Cartes> getMainJoueur = mainJoueur.getMainJoueur();
        List<Cartes> getDefausse = defausse.getDefausse();

        //Log.i("Couleur", "Nombre de carte dans la main " + getMainJoueur.size());

        holder.itemView.setOnClickListener(v -> {
            Log.i("Erreur","Je suis cliqué");
            /*Couleur couleurCartes = cartes.getCouleur();
            Couleur couleurDefausse = getDefausse.get(position).getCouleur();

            String numeroDefausse = getDefausse.get(position).getNumero();
            String numeroCartes = cartes.getNumero();*/

            /*Log.i("Couleur", "Nombre de carte dans la main " + getMainJoueur.size());
            Log.i("Couleur", "Nombre de carte dans la defausse " + getDefausse.size());

            Log.i("Couleur", "Couleur carte " +cartes.getCouleur());
            Log.i("Couleur", "Couleur defausse " + defausse.getDefausse().get(position).getCouleur());

            //Log.i("Couleur", "Numero cartes " + numeroCartes);
            //Log.i("Couleur", "Numero defausse " +numeroDefausse);*/

            if (cartes.isCarteSpe() == false) {
                //Log.i("Couleur", "Je suis rentré");
                if (cartes.getCouleur() == defausse.getDefausse().get(position).getCouleur() /*|| numeroCartes == numeroDefausse*/) {
                    //Log.i("Couleur", "Je suis bon");
                    getDefausse.add(getMainJoueur.remove(position));
                    defausse.setDefausse(getDefausse);
                    mainJoueur.setMainJoueur(getMainJoueur);
                    return;
                } else {
                    //Log.i("Couleur", "Je suis pas bon");
                }
            } else {
                //Log.i("Couleur", "Je suis bon");
                getDefausse.add(getMainJoueur.remove(position));
                defausse.setDefausse(getDefausse);
                mainJoueur.setMainJoueur(getMainJoueur);
            }

            //Log.i("Couleur", "Nombre de carte dans la main " + getMainJoueur.size());
            //Log.i("Couleur", "Nombre de carte dans la defausse " + getDefausse.size());
        });
    }

    //Ne pas modif
    @Override
    public int getItemCount() {
        return mainJoueur.getMainJoueur().size();
    }
}
