package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Converter Решение задачи 5.1.4. Создать convert(Iterator<Iterator>)
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 02.07.2018
 */
public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> iterators = it.next();

            @Override
            public boolean hasNext() {
                if (!iterators.hasNext() && it.hasNext()) {
                    iterators = it.next();
                }
                return iterators.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return iterators.next();
            }
        };
    }
}