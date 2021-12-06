package DesignFabrique;

import Cancaneur.*;

public class FabriqueDeCanard extends FabriqueDeCanardsAbstraite {
    @Override
    public Cancaneur creerColvert() {
        return new Colvert();
    }

    @Override
    public Cancaneur creerMandarin() {
        return new Mandarin();
    }
}

