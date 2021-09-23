package Arbre;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SuffixPathTreeIterator<T> implements Iterator<T>{
    private final Tree<T> treeToIterate;

    private boolean isRootProceed = false;
    private final Iterator<Tree<T>> itForest;
    private Iterator<T> itCurrentSubtree;

    public SuffixPathTreeIterator(Tree<T> treeToIterate) {
        this.treeToIterate = treeToIterate;
        this.itForest = this.treeToIterate.getForest().iterator();
    }

    @Override
    public boolean hasNext() {
        return !this.isRootProceed;
    }

    @Override
    public T next() {
        if (itCurrentSubtree == null || !itCurrentSubtree.hasNext()) {
            if (itForest.hasNext()) {
                itCurrentSubtree = itForest.next().prefixPathIterator();
            }else {
                if (!isRootProceed) {
                    isRootProceed = true;
                    return this.treeToIterate.getRootValues();
                }else {
                    throw new NoSuchElementException();
                }
            }
        }
        return itCurrentSubtree.next();
    }
}

