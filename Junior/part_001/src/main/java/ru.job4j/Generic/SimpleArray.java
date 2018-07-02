package ru.job4j.Generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleArray Решение задачи 5.2.1. Реализовать SimpleArray<T>
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 02.07.2018
 */
public class SimpleArray<T> implements Iterable {
    private Object[] arr;
    private int count = 0;

    SimpleArray(int size) {
        this.arr = new Object[size];
    }

    public void add(T model) {
        if (count > arr.length - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.arr[count++] = model;
    }

    public void set(int index, T model) {
        arr[index] = model;
    }

    public void delete(int index) {
        arr[index] = null;
        System.arraycopy(arr, index + 1, arr, index, index - 1);
    }

    T get(int index) {
        return (T) arr[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index;

            @Override
            public boolean hasNext() {
                return arr.length >= index;
            }

            @Override
            public T next() {
                if (count >= arr.length - 1) {
                    throw new NoSuchElementException();
                }
                index++;
                return (T) arr[count++];
            }
        };
    }
}