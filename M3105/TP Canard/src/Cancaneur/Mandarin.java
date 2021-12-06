package Cancaneur;

import Cancaneur.Cancaneur;
import DesignObserver.Observateur;

public class Mandarin implements Cancaneur {
    @Override
    public void cancaner() {
        System.out.println("Coincoin");
    }

    @Override
    public void enregistrerObservateur(Observateur observateur) {

    }

    @Override
    public void notifierObservateurs() {

    }
}
