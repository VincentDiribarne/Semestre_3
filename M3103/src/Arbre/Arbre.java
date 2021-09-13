package Arbre;

import java.util.List;

public interface Arbre<T> {
    T getArbresValues();
    List<Arbre<T>> getForet();

    int getHauteur();
    AvgHeightInfo getHauteurMoyenne();
    int getNumNodes();
    int getNumLeaves();

    static class AvgHeightInfo {
        private final float avgHeight;
        private final int numLeaves;

        public AvgHeightInfo(float avgHeight, int numLeaves) {
            this.avgHeight = avgHeight;
            this.numLeaves = numLeaves;
        }

        public float getAvgHeight() {
            return avgHeight;
        }

        public int getNumLeaves() {
            return numLeaves;
        }
    }

    void fillValuesPrefixPath(List<T> filler);

    void fillValuesSuffixePath(List<T> filler);

    void fillValuesSpanPath(List<T> filler);

}
