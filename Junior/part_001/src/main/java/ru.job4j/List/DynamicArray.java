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
    private Object[] container;
    private int index;
    private int modCount;
    private int count;
    private int size = 5;

    public DynamicArray(int size) {
        this.container = new Object[size];
    }

    public void add(E value) {
        if (index == container.length) {
            container = changeSize(container);
        }
        container[index++] = value;
    }

    public E get(int index) {
        return (E) container[index];
    }

    public Object[] changeSize(Object[] oldContainer) {
        modCount++;
        Object[] newContainer = new Object[size * 2];
        System.arraycopy(oldContainer, 0, newContainer, 0, oldContainer.length);
        return newContainer;
    }

    @Override
    public Iterator<E> iterator() {
        int expectedModCount = modCount;
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return container.length - 1 >= index;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (count >= container.length) {
                    throw new NoSuchElementException();
                }
                return (E) container[count++];
            }
        };
    }
}