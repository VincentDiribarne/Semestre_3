package DesignObserver;

import Cancaneur.Cancaneur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Observable implements CouacObservable {
    private List<Observateur> observateurs = new ArrayList<>();
    private Cancaneur canard;

    public Observable(Cancaneur canard) {
        this.canard = canard;
    }

    @Override
    public void enregistrerObservateur(Observateur observateur) {
        observateurs.add(observateur);
    }

    @Override
    public void notifierObservateurs() {
        Iterator<Observateur> iterator = observateurs.iterator();
        while (iterator.hasNext()) {
            Observateur obs = iterator.next();
            obs.actualiser(canard);
        }
    }
}
