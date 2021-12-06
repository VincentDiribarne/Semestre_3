package Cancaneur;

import DesignObserver.Observateur;

public class Appelant implements Cancaneur {
    @Override
    public void cancaner() {
        System.out.println("Couincouin");
    }

    @Override
    public void enregistrerObservateur(Observateur observateur) {

    }

    @Override
    public void notifierObservateurs() {

    }
}
