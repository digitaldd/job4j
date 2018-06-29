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
        }
        return even;
    }

    @Override
    public Object next() {
        int evenNumb = 0;
        for (int i = count; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                evenNumb = values[i];
                count = i;
                break;
            } else if (i == values.length - 1) {
                throw new NoSuchElementException();
            }
        }
        count++;
        return evenNumb;
    }
}