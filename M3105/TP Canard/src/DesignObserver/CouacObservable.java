package DesignObserver;

public interface CouacObservable {
    void enregistrerObservateur(Observateur observateur);
    void notifierObservateurs();
}
