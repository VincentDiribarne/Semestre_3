package DesignDecorateur;

import Cancaneur.Cancaneur;
import DesignObserver.Observateur;

public class CompteurDeCouacs implements Cancaneur {
    private Cancaneur cancaneur;
    private static int nombreDeCouacs;

    public CompteurDeCouacs(Cancaneur cancaneur) {
        this.cancaneur = cancaneur;
    }

    @Override
    public void cancaner() {
        cancaneur.cancaner();
        nombreDeCouacs++;
    }

    public static int getNombreDeCouacs() {
        return nombreDeCouacs;
    }

    @Override
    public void enregistrerObservateur(Observateur observateur) {

    }

    @Override
    public void notifierObservateurs() {

    }
}
