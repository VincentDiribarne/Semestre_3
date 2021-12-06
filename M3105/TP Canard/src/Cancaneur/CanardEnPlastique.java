package Cancaneur;

import DesignObserver.Observateur;
import DesignVisitor.Visitor;

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

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
