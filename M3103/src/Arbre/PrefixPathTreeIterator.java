package Arbre;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrefixPathTreeIterator<T> implements Iterator<T> {
    private final Tree<T> treeToIterate;

    private boolean isRootProceed = false;
    private final Iterator<Tree<T>> itForest;
    private Iterator<T> itCurrentSubtree;

    public PrefixPathTreeIterator(Tree<T> treeToIterate) {
        this.treeToIterate = treeToIterate;
        this.itForest = this.treeToIterate.getForest().iterator();
    }

    @Override
    public boolean hasNext() {
        return !this.isRootProceed || this.itForest.hasNext() || (this.itCurrentSubtree != null && this.itCurrentSubtree.hasNext());
    }

    @Override
    public T next() {
        if (!this.isRootProceed) {
            this.isRootProceed = true;
            return this.treeToIterate.getRootValues();
        }

        if (this.itCurrentSubtree == null || !this.itCurrentSubtree.hasNext()) {
            if (this.itForest.hasNext()) {
                this.itCurrentSubtree = this.itForest.next().prefixPathIterator();
            } else {
                throw new NoSuchElementException();
            }
        }
        return this.itCurrentSubtree.next();
    }
}
