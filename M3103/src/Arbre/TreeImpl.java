package Arbre;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeImpl<T> implements Tree<T> {
    private final T values;
    private final List<Tree<T>> foret;

    public TreeImpl(T values) {
        this.values = values;
        this.foret = new ArrayList<>();
    }

    @Override
    public T getRootValues() {
        return values;
    }

    @Override
    public List<Tree<T>> getForest() {
        return foret;
    }

    @Override
    public int getHeight() {
        if (this.foret.isEmpty()) return 0;
        int hMax = 0;
        for (Tree foret : foret) {
            if (foret.getHeight() > hMax) {
                hMax = foret.getHeight();
            }
        }
        return hMax + 1;
    }

    @Override
    public AvgHeightInfo getAvgHeight() {
        float balancedTotal = 0;
        int numLeaves = 0;

        if (this.foret.isEmpty()) {
            return new AvgHeightInfo(0, 1);
        }

        for (Tree foret : foret) {
            AvgHeightInfo ahi = foret.getAvgHeight();
            balancedTotal = +ahi.getAvgHeight() * ahi.getNumLeaves();
            numLeaves += ahi.getNumLeaves();
        }
        return new AvgHeightInfo(1 + balancedTotal / numLeaves, numLeaves);
    }

    @Override
    public int getNumNodes() {
        int total = 1;
        for (Tree foret : foret) {
            total += foret.getNumNodes();
        }
        return total;
    }

    @Override
    public int getNumLeaves() {
        if (this.foret.isEmpty()) {
            return 1;
        }
        int total = 1;
        for (Tree foret : foret) {
            total += foret.getNumLeaves();
        }
        return total;
    }

    @Override
    public void addTree(Tree<T> tree) {
        getForest().add(tree);
    }

    public void dumpTree() {
        System.out.print(getRootValues());
        if (!foret.isEmpty()) {
            System.out.print("(");
            for (Tree tree : foret) {
                tree.dumpTree();
            }
            System.out.print(")");
        }
    }

    @Override
    public Iterator<T> prefixPathIterator() {
        return new PrefixPathTreeIterator<>(this);
    }

    @Override
    public Iterator<T> suffixPathIterator() {
        return new SuffixPathTreeIterator<>(this);
    }

    @Override
    public Iterator<T> spanPathIterator() {
        return new SpanPathTreeIterator<>(this);
    }
}
