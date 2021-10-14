package Arbre;

import java.util.Iterator;

public class SpanPathTreeIterator<T> implements Iterator<T> {
    private final Tree<T> treeToIterate;

    private boolean isRootProceed = false;
    private final Iterator<Tree<T>> itForest;
    private Iterator<T> itCurrentSubtree;

    public SpanPathTreeIterator(Tree<T> treeToIterate) {
        this.treeToIterate = treeToIterate;
        this.itForest = this.treeToIterate.getForest().iterator();
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}
