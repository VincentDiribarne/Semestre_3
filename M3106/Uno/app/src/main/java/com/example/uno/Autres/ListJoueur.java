package com.example.uno.Autres;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListJoueur implements Serializable {
    public static List<Joueur> listJoueur = new ArrayList<>();

    public List<Joueur> getListJoueur() {
        return listJoueur;
    }

    public void setListJoueur(List<Joueur> listJoueur) {
        this.listJoueur = listJoueur;
    }
}
