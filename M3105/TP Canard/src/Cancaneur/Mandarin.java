package Cancaneur;

import Cancaneur.Cancaneur;
import DesignObserver.Observateur;
import DesignVisitor.Visitor;

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

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
