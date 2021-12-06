package Cancaneur;

import DesignObserver.CouacObservable;
import DesignVisitor.Visitable;

public interface Cancaneur extends CouacObservable, Visitable {
    void cancaner();
}

