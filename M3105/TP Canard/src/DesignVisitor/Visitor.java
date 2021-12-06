package DesignVisitor;

import Cancaneur.Appelant;
import Cancaneur.CanardEnPlastique;
import Cancaneur.Colvert;
import Cancaneur.Mandarin;
import DesignAdapteur.AdaptateurDOie;
import DesignComposite.Troupe;
import DesignDecorateur.CompteurDeCouacs;

public interface Visitor {
    void visit(Troupe t);
    void visit(Colvert c);
    void visit(Mandarin c);
    void visit(Appelant c);
    void visit(CanardEnPlastique c);
    void visit(AdaptateurDOie c);
    void visit(CompteurDeCouacs c);
    void visit(Visitable c);
}
