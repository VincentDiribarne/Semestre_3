package Arbre;

public interface SearchTree<T extends Comparable<T>> extends Tree<T> {

    /**
     * Return the left subtree or null
     * @return
     */
    SearchTree<T> getLeftSubtree();

    /**
     * Return the right subtree or null
     * @return
     */
    SearchTree<T> getRightSubtree();

    /**
     * return true if the value is in the tree, false otherwise
     * @param values the value
     * @return the search result
     */
    boolean contains(T values);

    /**
     * Insert a values in the tree. If the value already exists, the values will be inserted to its right
     * @param values
     */
    void insertValues(T values);

    /**
     * Delete value form tree
     * @param values
     * @throw NoSuchElementException if the value doesn't exist
     */
    void deleteValues(T values);
}
