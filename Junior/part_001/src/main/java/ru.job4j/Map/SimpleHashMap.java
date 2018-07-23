package ru.job4j.Map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleHashMap Решение задачи 8. Реализовать собственную структуру данных - HashMap
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 23.07.2018
 */
public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Bucket> {

    /**
     * storage
     */
    private Bucket<K, V>[] buckets;

    /**
     * modification count
     */
    private int modCount;

    /**
     * beginning size
     */
    private int size = 5;

    /**
     * quantity elements
     */
    private int count;

    public SimpleHashMap() {
        buckets = new Bucket[size];
    }

    private int hash(K key) {
        return key == null ? 0 : key.hashCode() ^ key.hashCode() >>> buckets.length;
    }

    public boolean insert(K key, V value) {
        if (count == size - 1) {
            buckets = resize(buckets);
        }
        boolean ins = false;
        if (check(key) && buckets[hash(key)] == null) {
            buckets[hash(key)] = new Bucket<>(key, value);
            ins = true;
            count++;
        }
        return ins;
    }

    public V get(K key) {
        return check(key) ? buckets[hash(key)].value : null;
    }

    public int getSize() {
        return size;
    }

    public int getCount() {
        return count;
    }

    boolean delete(K key) {
        boolean del = false;
        if (check(key) && buckets[hash(key)] != null) {
            buckets[hash(key)].value = null;
            del = true;
            count--;
        }
        return del;
    }

    public boolean check(K key) {
        boolean inSize = false;
        if (hash(key) < size) {
            inSize = true;
        }
        return inSize;
    }

    public Bucket[] resize(Bucket[] oldBuckets) {
        modCount++;
        size = count * 2;
        Bucket[] newBuckets = new Bucket[size];
        System.arraycopy(oldBuckets, 0, newBuckets, 0, oldBuckets.length);
        return newBuckets;
    }

    @Override
    public Iterator<Bucket> iterator() {
        return new Iterator<Bucket>() {
            int indexIter;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return count > indexIter;
            }

            @Override
            public Bucket next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Bucket<K, V> bucket = null;
                for (; indexIter <= buckets.length; indexIter++) {
                    if (buckets[indexIter].value != null) {
                        bucket = buckets[indexIter++];
                        break;
                    }
                }
                return bucket;
            }
        };
    }

    public class Bucket<K, V> {
        K key;
        V value;

        public Bucket(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + " " + value;
        }
    }
}