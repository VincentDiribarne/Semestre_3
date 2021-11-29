package DesignObserver;

import java.util.Observer;

public interface CouacObservable {
    void enregistrerObservateur(Observateur observateur);
    void notifierObservateurs();
}
