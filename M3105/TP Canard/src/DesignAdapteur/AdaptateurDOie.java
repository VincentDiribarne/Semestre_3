package DesignAdapteur;

import Cancaneur.*;
import DesignObserver.Observateur;
import DesignVisitor.Visitor;

public class AdaptateurDOie implements Cancaneur {

    private final Oie oie;

    public AdaptateurDOie(Oie oie) {
        this.oie = oie;
    }

    @Override
    public void cancaner() {
        oie.cacarder();
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
