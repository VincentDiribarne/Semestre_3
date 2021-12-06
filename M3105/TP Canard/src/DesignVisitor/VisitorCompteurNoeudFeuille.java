package DesignVisitor;

import Cancaneur.Appelant;
import Cancaneur.CanardEnPlastique;
import Cancaneur.Colvert;
import Cancaneur.Mandarin;
import DesignAdapteur.AdaptateurDOie;
import DesignComposite.Troupe;
import DesignDecorateur.CompteurDeCouacs;

public class VisitorCompteurNoeudFeuille implements Visitor {
    private int nbNoeud;
    private int nbFeuille;

    //Getters
    public int getNbNoeud() {
        return nbNoeud;
    }

    public int getNbFeuille() {
        return nbFeuille;
    }

    //Méthode visit
    @Override
    public void visit(Troupe t) {
        nbNoeud++;
    }

    @Override
    public void visit(Colvert c) {
        nbFeuille++;
    }

    @Override
    public void visit(Mandarin c) {
        nbFeuille++;
    }

    @Override
    public void visit(Appelant c) {
        nbFeuille++;
    }

    @Override
    public void visit(CanardEnPlastique c) {
        nbFeuille++;
    }

    @Override
    public void visit(AdaptateurDOie c) {
        nbFeuille++;
    }

    @Override
    public void visit(CompteurDeCouacs c) {
        nbNoeud++;
    }

    @Override
    public void visit(Visitable c) {
        System.out.println("classe pas encore gérée");
    }
}
