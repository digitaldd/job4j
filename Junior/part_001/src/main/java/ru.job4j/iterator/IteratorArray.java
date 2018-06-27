package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class ListCompare Решение задачи 5.1.1. Итератор для двухмерного массива int[][]
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 16.06.2018
 */
public class IteratorArray implements Iterator {
    private final int[][] values;
    private int i = 0;
    private int j = 0;

    IteratorArray(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return values.length > i;
    }

    @Override
    public Object next() {
        if (i >= values.length) {
            throw new NoSuchElementException();
        }
        int res = values[i][j++];
        if (j >= values[i].length) {
            j = 0;
            i++;
        }
        return res;
    }
}