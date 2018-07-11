package ru.job4j.List;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class DynamicArray Решение задачи 5.3.1. Создать динамический список на базе массива
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 10.07.2018
 */
public class DynamicArray<E> implements Iterable<E> {
    public Object[] container;
    private int modCount;
    private int count;
    private int size = 5;

    public DynamicArray(int size) {
        this.container = new Object[size];
    }

    public void add(E value) {
        if (count == container.length) {
            container = changeSize(container);
        }
        container[count++] = value;
    }

    public E get(int index) {
        return (E) container[index];
    }

    public Object[] changeSize(Object[] oldContainer) {
        modCount++;
        size = size * 2;
        Object[] newContainer = new Object[size];
        System.arraycopy(oldContainer, 0, newContainer, 0, oldContainer.length);
        return newContainer;
    }

    @Override
    public Iterator<E> iterator() {
        int expectedModCount = modCount;
        return new Iterator<E>() {
            int indexIter;

            @Override
            public boolean hasNext() {
                return container.length - 1 >= indexIter;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (count >= container.length) {
                    throw new NoSuchElementException();
                }
                return (E) container[indexIter++];
            }
        };
    }
}