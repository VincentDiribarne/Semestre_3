package com.example.uno.Autres;

import java.util.ArrayList;
import java.util.List;

public class ListCartes {
    public List<Cartes> cartes = new ArrayList<>();

    public void debut() {
        //Jaune
        cartes.add(new Cartes(0, "Jaune", ""));

        cartes.add(new Cartes(1, "Jaune", ""));
        cartes.add(new Cartes(2, "Jaune", ""));
        cartes.add(new Cartes(3, "Jaune", ""));
        cartes.add(new Cartes(4, "Jaune", ""));
        cartes.add(new Cartes(5, "Jaune", ""));
        cartes.add(new Cartes(6, "Jaune", ""));
        cartes.add(new Cartes(7, "Jaune", ""));
        cartes.add(new Cartes(8, "Jaune", ""));
        cartes.add(new Cartes(9, "Jaune", ""));

        cartes.add(new Cartes(1, "Jaune", ""));
        cartes.add(new Cartes(2, "Jaune", ""));
        cartes.add(new Cartes(3, "Jaune", ""));
        cartes.add(new Cartes(4, "Jaune", ""));
        cartes.add(new Cartes(5, "Jaune", ""));
        cartes.add(new Cartes(6, "Jaune", ""));
        cartes.add(new Cartes(7, "Jaune", ""));
        cartes.add(new Cartes(8, "Jaune", ""));
        cartes.add(new Cartes(9, "Jaune", ""));

        //Vert
        cartes.add(new Cartes(0, "Vert", ""));

        cartes.add(new Cartes(1, "Vert", ""));
        cartes.add(new Cartes(2, "Vert", ""));
        cartes.add(new Cartes(3, "Vert", ""));
        cartes.add(new Cartes(4, "Vert", ""));
        cartes.add(new Cartes(5, "Vert", ""));
        cartes.add(new Cartes(6, "Vert", ""));
        cartes.add(new Cartes(7, "Vert", ""));
        cartes.add(new Cartes(8, "Vert", ""));
        cartes.add(new Cartes(9, "Vert", ""));

        cartes.add(new Cartes(1, "Vert", ""));
        cartes.add(new Cartes(2, "Vert", ""));
        cartes.add(new Cartes(3, "Vert", ""));
        cartes.add(new Cartes(4, "Vert", ""));
        cartes.add(new Cartes(5, "Vert", ""));
        cartes.add(new Cartes(6, "Vert", ""));
        cartes.add(new Cartes(7, "Vert", ""));
        cartes.add(new Cartes(8, "Vert", ""));
        cartes.add(new Cartes(9, "Vert", ""));

        //Rouge
        cartes.add(new Cartes(0, "Rouge", ""));

        cartes.add(new Cartes(1, "Rouge", ""));
        cartes.add(new Cartes(2, "Rouge", ""));
        cartes.add(new Cartes(3, "Rouge", ""));
        cartes.add(new Cartes(4, "Rouge", ""));
        cartes.add(new Cartes(5, "Rouge", ""));
        cartes.add(new Cartes(6, "Rouge", ""));
        cartes.add(new Cartes(7, "Rouge", ""));
        cartes.add(new Cartes(8, "Rouge", ""));
        cartes.add(new Cartes(9, "Rouge", ""));

        cartes.add(new Cartes(1, "Rouge", ""));
        cartes.add(new Cartes(2, "Rouge", ""));
        cartes.add(new Cartes(3, "Rouge", ""));
        cartes.add(new Cartes(4, "Rouge", ""));
        cartes.add(new Cartes(5, "Rouge", ""));
        cartes.add(new Cartes(6, "Rouge", ""));
        cartes.add(new Cartes(7, "Rouge", ""));
        cartes.add(new Cartes(8, "Rouge", ""));
        cartes.add(new Cartes(9, "Rouge", ""));

        //Bleu
        cartes.add(new Cartes(0, "Bleu", ""));

        cartes.add(new Cartes(1, "Bleu", ""));
        cartes.add(new Cartes(2, "Bleu", ""));
        cartes.add(new Cartes(3, "Bleu", ""));
        cartes.add(new Cartes(4, "Bleu", ""));
        cartes.add(new Cartes(5, "Bleu", ""));
        cartes.add(new Cartes(6, "Bleu", ""));
        cartes.add(new Cartes(7, "Bleu", ""));
        cartes.add(new Cartes(8, "Bleu", ""));
        cartes.add(new Cartes(9, "Bleu", ""));

        cartes.add(new Cartes(1, "Bleu", ""));
        cartes.add(new Cartes(2, "Bleu", ""));
        cartes.add(new Cartes(3, "Bleu", ""));
        cartes.add(new Cartes(4, "Bleu", ""));
        cartes.add(new Cartes(5, "Bleu", ""));
        cartes.add(new Cartes(6, "Bleu", ""));
        cartes.add(new Cartes(7, "Bleu", ""));
        cartes.add(new Cartes(8, "Bleu", ""));
        cartes.add(new Cartes(9, "Bleu", ""));

        //Carte spéciale
        cartes.add(new Cartes("Jaune", "", "+2"));
        cartes.add(new Cartes("Jaune", "", "+2"));
        cartes.add(new Cartes("Vert", "", "+2"));
        cartes.add(new Cartes("Vert", "", "+2"));
        cartes.add(new Cartes("Bleu", "", "+2"));
        cartes.add(new Cartes("Bleu", "", "+2"));
        cartes.add(new Cartes("Rouge", "", "+2"));
        cartes.add(new Cartes("Rouge", "", "+2"));

        cartes.add(new Cartes("Jaune", "", "Passe ton tour"));
        cartes.add(new Cartes("Jaune", "", "Passe ton tour"));
        cartes.add(new Cartes("Vert", "", "Passe ton tour"));
        cartes.add(new Cartes("Vert", "", "Passe ton tour"));
        cartes.add(new Cartes("Bleu", "", "Passe ton tour"));
        cartes.add(new Cartes("Bleu", "", "Passe ton tour"));
        cartes.add(new Cartes("Rouge", "", "Passe ton tour"));
        cartes.add(new Cartes("Rouge", "", "Passe ton tour"));

        cartes.add(new Cartes("Jaune", "", "Change de sens"));
        cartes.add(new Cartes("Jaune", "", "Change de sens"));
        cartes.add(new Cartes("Vert", "", "Change de sens"));
        cartes.add(new Cartes("Vert", "", "Change de sens"));
        cartes.add(new Cartes("Bleu", "", "Change de sens"));
        cartes.add(new Cartes("Bleu", "", "Change de sens"));
        cartes.add(new Cartes("Rouge", "", "Change de sens"));
        cartes.add(new Cartes("Rouge", "", "Change de sens"));

        cartes.add(new Cartes("Rouge", "", "Joker"));
        cartes.add(new Cartes("Vert", "", "Joker"));
        cartes.add(new Cartes("Jaune", "", "Joker"));
        cartes.add(new Cartes("Bleu", "", "Joker"));

        cartes.add(new Cartes("Rouge", "", "+4"));
        cartes.add(new Cartes("Vert", "", "+4"));
        cartes.add(new Cartes("Jaune", "", "+4"));
        cartes.add(new Cartes("Bleu", "", "+4"));
    }

    public void supprimerCartes() {
        //cartes.remove();
    }

    public List<Cartes> getCartes() {
        return cartes;
    }
}
