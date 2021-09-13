package Arbre;

import java.util.ArrayList;
import java.util.List;

public class ArbreImple<T> implements Arbre<T>{
    private T values;
    private final List<Arbre<T>> foret;

    public ArbreImple(T values) {
        this.values = values;
        this.foret = new ArrayList<>();
    }

    @Override
    public T getArbresValues() {
        return null;
    }

    @Override
    public List<Arbre<T>> getForet() {
        return foret;
    }
    public int vide() {
        if(this.foret.isEmpty()) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getHauteur() {
        if (this.foret.isEmpty()) return 0;
        int hMax = 0;
        for (Arbre foret : foret) {
            if (foret.getHauteur() > hMax) {
                hMax = foret.getHauteur();
            }
        }
        return hMax + 1;
    }

    @Override
    public AvgHeightInfo getHauteurMoyenne() {
        float balancedTotal = 0;
        int numLeaves = 0;

        if(this.foret.isEmpty()) {
            return new AvgHeightInfo(0,1);
        }

        for(Arbre foret : foret) {
            AvgHeightInfo ahi = foret.getHauteurMoyenne();
            balancedTotal =+ ahi.getAvgHeight() * ahi.getNumLeaves();
            numLeaves += ahi.getNumLeaves();
        }
        return new AvgHeightInfo(1 + balancedTotal / numLeaves, numLeaves);
    }

    @Override
    public int getNumNodes() {
        int total = 1;
        for (Arbre foret : foret) {
            total += foret.getNumNodes();
        }
        return total;
    }

    @Override
    public int getNumLeaves() {
        if(this.foret.isEmpty()) {
            return 1;
        }
        int total = 1;
        for (Arbre foret : foret) {
            total += foret.getNumLeaves();
        }
        return total;
    }

    @Override
    public void fillValuesPrefixPath(List<T> filler) {
        filler.add(this.values);
        for (Arbre foret: foret) {
            fillValuesPrefixPath(filler);
        }
    }

    @Override
    public void fillValuesSuffixePath(List<T> filler) {
        for (Arbre foret: foret) {
            fillValuesPrefixPath(filler);
        }
        filler.add(this.values);
    }

    @Override
    public void fillValuesSpanPath(List<T> filler) {

    }
}
