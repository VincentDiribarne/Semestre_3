package Hashage;

import Hashage.exceptions.CompleteTableException;
import Hashage.exceptions.NullKeyException;

import java.util.*;

public class MapImpl<K, V> implements Map<K, V> {
    private static final int ARRAYSIZE = 10;
    private final List<MapEntryImpl<K, V>>[] tab = new List[ARRAYSIZE];
    private int nbEntry = 0;


    static class MapEntryImpl<K, V> implements MapEntry<K, V> {
        private final K key;
        private V value;

        public MapEntryImpl(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                MapEntryImpl<K, V> mei = (MapEntryImpl<K, V>) obj;
                return this.key.equals(mei.key);
            } catch (ClassCastException ex) {
                return false;
            }
        }
    }

    public class MapImplIterator<K, V> implements Iterator<MapEntry<K, V>> {
        private int iTab = 0;
        private Iterator<MapEntryImpl<K, V>> itCurrentList;

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public MapEntry<K, V> next() {
            if (this.itCurrentList != null && this.itCurrentList.hasNext()) {
                return this.itCurrentList.next();
            }

            this.iTab++;
            while (this.iTab < tab.length && (tab[this.iTab] == null || tab[this.iTab].isEmpty())) {
                this.iTab++;
            }

            if (this.iTab < tab.length) {
                this.itCurrentList = tab[this.iTab].iterator();
                return this.itCurrentList.next();
            } else  {
                throw new NoSuchElementException();
            }
        }
    }

    @Override
    public void put(Object key, Object value) throws NullKeyException, CompleteTableException {
        final int idxKey = computerTabIndix((K) key);

        if (this.tab[idxKey] == null) {
            this.tab[idxKey] = new LinkedList<>();
        }

        for (MapEntryImpl<K, V> entry : this.tab[idxKey]) {
            if (entry.key.equals(key)) {
                entry.value = (V) value;
                return;
            }
        }

        this.tab[idxKey].add(new MapEntryImpl(key, value));
        nbEntry++;
    }

    @Override
    public Object remove(Object key) throws NullKeyException {
        final int idxKey = computerTabIndix((K) key);
        if (this.tab[idxKey] == null) {
            return null;
        }

        final ListIterator<MapEntryImpl<K, V>> it = this.tab[idxKey].listIterator();
        while (it.hasNext()) {
            final MapEntryImpl<K, V> cell = it.next();
            if (cell.key.equals(key)) {
                it.remove();
                this.nbEntry--;
                return cell.value;
            }
        }
        return null;
    }

    @Override
    public Object get(Object key) throws NullKeyException {
        final int idxKey = computerTabIndix((K) key);
        if (this.tab[idxKey] == null) {
            return false;
        }

        for (MapEntryImpl<K, V> entry : this.tab[idxKey]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public boolean contains(Object key) throws NullKeyException {
        final int idxKey = computerTabIndix((K) key);
        if (this.tab[idxKey] == null) {
            return false;
        }

        return this.tab[idxKey].contains(new MapEntryImpl<>(key, null));
    }

    @Override
    public int size() {
        return this.nbEntry;
    }

    @Override
    public Iterator<MapEntry<K, V>> iterator() {

    }

    private int computerTabIndix(K key) {
        if (key == null) {
            throw new NullKeyException();
        }

        return key.hashCode() % this.tab.length;
    }
}
