package Hashage;

import Hashage.exceptions.CompleteTableException;
import Hashage.exceptions.NullKeyException;

import java.util.*;

public class MapImpl<K, V> implements Map<K, V> {
    private static final int ARRAYSIZE = 10;
    private final List<MapEntryImpl<K, V>>[] tab;
    private int nbEntry = 0;

    public MapImpl() {
        this.tab = new List[ARRAYSIZE];
    }

    public MapImpl(int size) {
        this.tab = new List[size];
    }

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

    public class MapImplIterator implements Iterator<MapEntry<K, V>> {
        private int indexFuturTab = -1;
        private MapEntry<K, V> nextEntryToReturn;
        private MapEntry<K, V> currentElement;
        private Iterator<MapEntryImpl<K, V>> itCurrentList;
        private Iterator<MapEntryImpl<K, V>> futurListIt;

        public MapImplIterator() {
            this.getFuturListIt();
            this.itCurrentList = this.futurListIt;
            if (this.itCurrentList != null) {
                this.getFuturListIt();
            }
        }

        @Override
        public boolean hasNext() {
            return this.itCurrentList != null && this.itCurrentList.hasNext();
        }

        @Override
        public MapEntry<K, V> next() {
            if (this.itCurrentList == null) {
                throw new NoSuchElementException();
            }
            if (this.itCurrentList.hasNext()) {
                return this.itCurrentList.next();
            } else if (this.futurListIt == null) {
                throw new NoSuchElementException();
            } else {
                this.itCurrentList = this.futurListIt;
                this.getFuturListIt();
                return this.itCurrentList.next();
            }
        }

        public void getFuturListIt() {
            do {
                this.indexFuturTab++;
            } while (this.indexFuturTab < tab.length && (tab[this.indexFuturTab] == null || tab[this.indexFuturTab].isEmpty()));

            if (this.indexFuturTab >= tab.length) {
                this.nextEntryToReturn = null;
            } else {
                this.itCurrentList = tab[this.indexFuturTab].iterator();
                this.nextEntryToReturn = this.itCurrentList.next();
            }
        }

        private void goToNextEntry() {
            if (this.itCurrentList != null && this.itCurrentList.hasNext()) {
                this.nextEntryToReturn = this.itCurrentList.next();
            } else {
                do {
                    this.indexFuturTab++;
                } while (this.indexFuturTab < tab.length && (tab[this.indexFuturTab] == null || tab[this.indexFuturTab].isEmpty()));

                if (this.indexFuturTab >= tab.length) {
                    this.nextEntryToReturn = null;
                } else {
                    this.itCurrentList = tab[this.indexFuturTab].iterator();
                    this.nextEntryToReturn = this.itCurrentList.next();
                }
            }
        }

        public void remove() {
            if (this.currentElement == null) {
                throw new IllegalStateException("next() not called");
            }
            this.itCurrentList.remove();
            nbEntry--;
        }
    }

    @Override
    public void put(Object key, Object value) {
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
    public Object remove(Object key) {
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
    public boolean contains(Object key) {
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
        return new MapImplIterator();
    }

    private int computerTabIndix(K key) {
        if (key == null) {
            throw new NullKeyException();
        }

        return key.hashCode() % this.tab.length;
    }
}
