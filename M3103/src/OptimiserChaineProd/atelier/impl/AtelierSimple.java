package OptimiserChaineProd.atelier.impl;

import OptimiserChaineProd.atelier.Atelier;
import OptimiserChaineProd.atelier.Chaine;

import java.util.ArrayList;

public class AtelierSimple implements Atelier {

    private final Chaine chaine0;
    private final Chaine chaine1;
    private ArrayList<Long> tempsChangement0a1;
    private ArrayList<Long> tempsChangement1a0;

    public AtelierSimple(Chaine chaine0, Chaine chaine1, ArrayList<Long> tempsChangement0a1, ArrayList<Long> tempsChangement1a0) {
        this.chaine0 = chaine0;
        this.chaine1 = chaine1;
        this.tempsChangement0a1 = tempsChangement0a1;
        this.tempsChangement1a0 = tempsChangement1a0;
        this.verifierCoherenceAterlier();
    }

    @Override
    public int getLongueurChaines() {
        return this.chaine0.getLongueur();
    }

    @Override
    public int getNbChaines() {
        return 2;
    }

    @Override
    public Chaine getChaine(int i) {
        return switch (i) {
            case 0 -> this.chaine0;
            case 1 -> this.chaine1;
            default -> throw new IndexOutOfBoundsException();
        };
    }

    @Override
    public long getTempsChangement(int indiceChaineA, int indiceChaineB, int indicePosteDepart) {
        if (indiceChaineA == 0) {
            if (indiceChaineB == 0) {
                return 0;
            } else {
                return this.tempsChangement0a1.get(indicePosteDepart);
            }
        }
        if (indiceChaineA == 1) {
            if (indiceChaineB == 1) {
                return 0;
            } else {
                return this.tempsChangement1a0.get(indicePosteDepart);
            }
        }
        throw new IllegalArgumentException("Mauvais indice de chaine");
    }

    private void verifierCoherenceAterlier() {
        if (this.chaine0.getLongueur() != this.chaine1.getLongueur()) {
            throw new IllegalArgumentException("Les chaines doivent être de même longueur");
        }
        final int tailleTpsChang = this.chaine0.getLongueur() - 1;
        if (this.tempsChangement0a1.size() != tailleTpsChang
                || this.tempsChangement1a0.size() != tailleTpsChang) {
            throw new IllegalArgumentException("Nombre de temps de changement invalide");
        }
        if (this.tempsChangement0a1.stream().anyMatch(c -> c < 0)
                || this.tempsChangement1a0.stream().anyMatch(c -> c < 0)) {
            throw new IllegalArgumentException("Les temps de changement doivent être positifs ou nuls");
        }
    }
}
