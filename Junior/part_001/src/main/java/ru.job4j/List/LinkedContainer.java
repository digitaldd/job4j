package ru.job4j.List;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class LinkedContainer Решение задачи 5.3.2. Создать контейнер на базе связанного списка
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 11.07.2018
 */
public class LinkedContainer<E> implements Iterable<E> {
    private int modCount;
    private int count;
    private Node<E> first;

    /**
     * add element value to node
     */
    public void add(E value) {
        Node<E> newLink = new Node<>(value);
        newLink.next = this.first;
        first = newLink;
        count++;
        modCount++;
    }

    /**
     * get element on int index
     *
     * @return element
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
     * get int size
     */
    public int getSize() {
        return this.count;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int indexIter;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return count > indexIter;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(indexIter++);
            }
        };
    }

    private class Node<E> {
        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }
}