package DesignFabrique;

import Cancaneur.*;
import DesignDecorateur.CompteurDeCouacs;

public class FabriqueDeComptage extends FabriqueDeCanardsAbstraite {

    @Override
    public Cancaneur creerColvert() {
        return new CompteurDeCouacs(new Colvert());
    }

    @Override
    public Cancaneur creerMandarin() {
        return new CompteurDeCouacs(new Mandarin());
    }
}
