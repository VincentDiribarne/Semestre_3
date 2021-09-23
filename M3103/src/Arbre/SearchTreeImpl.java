package Arbre;

import java.util.Iterator;
import java.util.List;

public class SearchTreeImpl<T extends Comparable<T>> implements SearchTree<T> {
    private T value;
    private SearchTree<T> leftSubtree;
    private SearchTree<T> rightSubtree;

    public SearchTreeImpl(T value, SearchTree<T> leftSubtree, SearchTree<T> rightSubtree) {
        this.value = value;
        this.leftSubtree = leftSubtree;
        this.rightSubtree = rightSubtree;
    }

    @Override
    public SearchTree<T> getLeftSubtree() {
        return null;
    }

    @Override
    public SearchTree<T> getRightSubtree() {
        return null;
    }

    @Override
    public boolean contains(T values) {
        return false;
    }

    @Override
    public void insertValues(T values) {

    }

    @Override
    public void deleteValues(T values) {

    }

    @Override
    public T getRootValues() {
        return null;
    }

    @Override
    public List<Tree<T>> getForest() {
        return null;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public AvgHeightInfo getAvgHeight() {
        return null;
    }

    @Override
    public int getNumNodes() {
        return 0;
    }

    @Override
    public int getNumLeaves() {
        return 0;
    }

    @Override
    public Iterator<T> prefixPathIterator() {
        return null;
    }

    @Override
    public void addTree(Tree<T> tree) {}
}
