package Cancaneur;

import DesignObserver.CouacObservable;
import DesignObserver.Observable;
import DesignObserver.Observateur;
import DesignVisitor.Visitor;

public class Colvert implements Cancaneur, CouacObservable {
    private CouacObservable couacObservable;

    public Colvert() {
         this.couacObservable = new Observable(this);
    }

    @Override
    public void cancaner() {
        System.out.println("Coincoin");
        couacObservable.notifierObservateurs();
    }

    public void enregistrerObservateur(Observateur observateur) {
        couacObservable.enregistrerObservateur(observateur);
    }

    public void notifierObservateurs() {
        couacObservable.notifierObservateurs();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
