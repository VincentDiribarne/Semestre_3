package Arbre;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SearchTreeImpl<T extends Comparable<T>> implements SearchTree<T> {
    private T value;
    private SearchTreeImpl leftSubtree;
    private SearchTreeImpl rightSubtree;

    public SearchTreeImpl(T value) {
        this.value = value;
    }

    @Override
    public SearchTree<T> getLeftSubtree() {
        return leftSubtree;
    }

    @Override
    public SearchTree<T> getRightSubtree() {
        return rightSubtree;
    }

    @Override
    public boolean contains(T values) {
        final int result = this.getRootValues().compareTo(values);

        if (result == 0) {
            return true;
        }

        if (result > 0 && this.leftSubtree != null) {
            return this.leftSubtree.contains(values);
        }

        if (result < 0 && this.rightSubtree != null) {
            return this.rightSubtree.contains(values);
        }

        return false;
    }

    @Override
    public void insertValues(T values) {
        int result = this.getRootValues().compareTo(values);

        if (result > 0) {
            if (this.leftSubtree == null) {
                leftSubtree = new SearchTreeImpl<>(value);
            } else {
                leftSubtree.insertValues(values);
            }
        }

        if (result < 0) {
            if (this.rightSubtree == null) {
                rightSubtree = new SearchTreeImpl<>(value);
            } else {
                rightSubtree.insertValues(values);
            }
        }
        //result == 0, je ne fais pas de return (valeur déjà présente)
    }

    @Override
    public void deleteValues(T values) {
        int result = this.getRootValues().compareTo(values);

    }

    @Override
    public T getRootValues() {
        return value;
    }


    /*@Override
    public void fillValuesPrefixPath(List<T> filler) {
        filler.add(this.rootValue);
        if (this.leftSubtree != null) {
            this.leftSubtree.fillValuesPrefixPath(filler);
        }

        if(this.rightSubtree != null) {
            this.rightSubtree.fillValuesPrefixPath(filler);
        }
    }*/

    /*@Override
    public void fillValuesSuffixPath(List<T> filler) {
        if (this.leftSubtree != null) {
            this.leftSubtree.fillValuesSuffixPath(filler);
        }

        if(this.rightSubtree != null) {
            this.rightSubtree.fillValuesSuffixPath(filler);
        }
        filler.add(this.rootValue);
    }*/

    /*@Override
    public void fillValuesSpanPath(List<T> filler) {

    }*/

    @Override
    public List<Tree<T>> getForest() {
        List<Tree<T>> forest = new ArrayList<>(2);
        if (this.leftSubtree != null) forest.add(leftSubtree);
        if (this.rightSubtree != null) forest.add(rightSubtree);
        return Collections.unmodifiableList(forest);
    }

    @Override
    public int getHeight() {
        int leftHeight = 0, rightHeight = 0;
        if (this.leftSubtree == null && this.rightSubtree == null) {
            return 0;
        }

        if (this.leftSubtree != null) {
            leftHeight = this.leftSubtree.getHeight();
        }

        if (this.rightSubtree != null) {
            rightHeight = this.rightSubtree.getHeight();
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public AvgHeightInfo getAvgHeight() {
        float balancedTotal = 0;
        int numLeaves = 0;

        if (this.leftSubtree != null) {
            AvgHeightInfo info = this.leftSubtree.getAvgHeight();
            balancedTotal += info.getAvgHeight() * info.getNumLeaves();
            numLeaves = info.getNumLeaves();
        }

        if (this.rightSubtree != null) {
            AvgHeightInfo info = this.rightSubtree.getAvgHeight();
            balancedTotal += info.getAvgHeight() * info.getNumLeaves();
            numLeaves = info.getNumLeaves();
        }

        if (numLeaves == 0) {
            return new AvgHeightInfo(0, 1);
        }

        return new AvgHeightInfo(balancedTotal / numLeaves, numLeaves);
    }

    @Override
    public int getNumNodes() {
        int numNodes = 1;


        if (this.leftSubtree != null) {
            numNodes += this.leftSubtree.getNumNodes();
        }

        if (this.rightSubtree != null) {
            numNodes += this.rightSubtree.getNumNodes();
        }

        return numNodes;
    }

    @Override
    public int getNumLeaves() {
        int numLeaves = 1;

        if (this.leftSubtree == null && this.rightSubtree == null) {
            return 1;
        }

        if (this.leftSubtree != null) {
            numLeaves += this.leftSubtree.getNumLeaves();
        }

        if (this.rightSubtree != null) {
            numLeaves += this.rightSubtree.getNumLeaves();
        }

        return numLeaves;
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


    @Override
    public void addTree(Tree<T> tree) {

    }

    @Override
    public void dumpTree() {
        System.out.print(getRootValues());
        if (this.leftSubtree != null) {
            System.out.print("(");
            this.leftSubtree.dumpTree();
            System.out.print(")");
        }

        if (this.rightSubtree != null) {
            System.out.print("(");
            this.rightSubtree.dumpTree();
            System.out.print(")");
        }
    }
}
