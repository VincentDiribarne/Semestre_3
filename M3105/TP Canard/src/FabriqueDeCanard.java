class FabriqueDeCanard extends FabriqueDeCanardsAbstraite {
    @Override
    public Cancaneur creerColvert() {
        return new Colvert();
    }

    @Override
    public Cancaneur creerMandarin() {
        return new Mandarin();
    }
}

class FabriqueDeComptage extends FabriqueDeCanardsAbstraite {

    @Override
    public Cancaneur creerColvert() {
        return new CompteurDeCouacs(new Colvert());
    }

    @Override
    public Cancaneur creerMandarin() {
        return new CompteurDeCouacs(new Mandarin());
    }
}
