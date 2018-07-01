package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class IteratorSimpleNumber Решение задачи 5.1.3. Создать итератор простые числа
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 01.07.2018
 */
public class IteratorSimpleNumber implements Iterator {
    private final int[] values;
    private int count = 0;

    IteratorSimpleNumber(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean simple = false;
        for (int i = count; i < values.length; i++) {
            simple = values[i] == 2 || values[i] % 2 != 0 && values[i] != 1;
            if (simple) {
                break;
            }
        }
        return simple;
    }

    @Override
    public Object next() {
        int simpleNumb = 0;
        for (int i = count; i <= values.length; i++) {
            if (i > values.length - 1) {
                throw new NoSuchElementException();
            } else if (values[i] == 2 || values[i] % 2 != 0 && values[i] != 1) {
                simpleNumb = values[i];
                count = i;
                break;
            }
        }
        count++;
        return simpleNumb;
    }
}