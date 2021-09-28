package Hashage;

import Hashage.exceptions.CompleteTableException;
import Hashage.exceptions.NullKeyException;

import java.util.Iterator;
import java.util.List;

public class MapImpl<K, V> implements Map<K, V> {
    private List<MapEntryImpl<K, V>>[] tab;
    static class MapEntryImpl<K, V> implements MapEntry<K, V> {
        private K key;
        private V value;

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }
    }

    @Override
    public void put(Object key, Object value) throws NullKeyException, CompleteTableException {

    }

    @Override
    public Object remove(Object key) throws NullKeyException {
        return null;
    }

    @Override
    public Object get(Object key) throws NullKeyException {
        return null;
    }

    @Override
    public boolean contains(Object key) throws NullKeyException {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<MapEntry<K, V>> iterator() {
        return null;
    }
}
