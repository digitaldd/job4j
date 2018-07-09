package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class IteratorEven Решение задачи 5.1.2. Создать итератор четные числа
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 29.06.2018
 */
public class IteratorEven implements Iterator {
    private final int[] values;
    private int count = 0;

    IteratorEven(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean even = false;
        for (int i = count; i < values.length; i++) {
            even = values[i] % 2 == 0;
            if (even) {
                break;
            }
            count++;
        }
        return even;
    }

    @Override
    public Object next() {
        hasNext();
        if (count >= values.length) {
            throw new NoSuchElementException();
        }
        return values[count++];
    }
}