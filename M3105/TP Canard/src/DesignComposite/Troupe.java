package DesignComposite;

import Cancaneur.Cancaneur;
import DesignObserver.Observateur;

import java.util.ArrayList;
import java.util.List;

public class Troupe implements Cancaneur {
    private final List<Cancaneur> cancaneurs = new ArrayList<>();

    public void add(Cancaneur cancaneur) {
        cancaneurs.add(cancaneur);
    }

    @Override
    public void cancaner() {
        for (Cancaneur cancaneur: cancaneurs) {
            cancaneur.cancaner();
        }
    }


    @Override
    public void enregistrerObservateur(Observateur observateur) {

    }

    @Override
    public void notifierObservateurs() {

    }
}
