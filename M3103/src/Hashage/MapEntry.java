package Hashage;

/**
 * An entry of a Map, representing a pair of a key and a value.
 * @author rvenant
 */
public interface MapEntry<K, V> {
    /**
     * Get the key in the entry
     * @return the key
     */
    K getKey();
    
    /**
     * Get the value in the entry
     * @return the value
     */
    V getValue();
}
