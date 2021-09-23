package Arbre;

import java.util.Iterator;
import java.util.List;

public interface Tree<T> {
    T getRootValues();
    List<Tree<T>> getForest();

    int getHeight();
    AvgHeightInfo getAvgHeight();
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

    Iterator<T> prefixPathIterator();

    void addTree(Tree<T> tree);
}
