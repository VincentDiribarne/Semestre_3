package OptimiserChaineProd.atelier.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import OptimiserChaineProd.atelier.Chaine;
import OptimiserChaineProd.atelier.Poste;

public class ChaineSimple implements Chaine {

    private final long tempsEntree;
    private final long tempsSorte;
    private final ArrayList<Poste> postes;

    public ChaineSimple(List<Poste> postes, long tempsEntree, long tempsSortie) {
        if (postes == null || postes.isEmpty()) {
            throw new IllegalArgumentException("Une chaine doit avoir au moins un poste");
        }
        if (tempsEntree < 0 || tempsSortie < 0) {
            throw new IllegalArgumentException("Le temps d'entrée ou de sortie d'une chaine doit être positif ou nul");
        }
        this.postes = new ArrayList<>(postes);

        this.tempsEntree = tempsEntree;
        this.tempsSorte = tempsSortie;
    }

    @Override
    public int getLongueur() {
        return this.postes.size();
    }

    @Override
    public long getTempsEntree() {
        return this.tempsEntree;
    }

    @Override
    public long getTempsSortie() {
        return this.tempsSorte;
    }

    @Override
    public Poste getPoste(int i) {
        return this.postes.get(i);
    }

    @Override
    public Iterator<Poste> postesIterator() {
        return this.postes.iterator();
    }
}
