class FabriqueDeCanard extends FabriqueDeCanardsAbstraite {
    @Override
    public Colvert creerColvert() {
        return new Colvert();
    }

    @Override
    public Mandarin creerMandarin() {
        return new Mandarin();
    }
}

class FabriqueDeComptage extends FabriqueDeCanardsAbstraite {

    @Override
    public Colvert creerColvert() {
        return new CompteurDeCouacs(new Colvert());
    }

    @Override
    public Mandarin creerMandarin() {
        return new CompteurDeCouacs(new Mandarin());
    }
}
