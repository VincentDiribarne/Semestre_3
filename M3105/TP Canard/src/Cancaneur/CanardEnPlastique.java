package Cancaneur;

import DesignObserver.Observateur;

public class CanardEnPlastique implements Cancaneur {
    @Override
    public void cancaner() {
        System.out.println("Couic");
    }

    @Override
    public void enregistrerObservateur(Observateur observateur) {

    }

    @Override
    public void notifierObservateurs() {

    }
}
