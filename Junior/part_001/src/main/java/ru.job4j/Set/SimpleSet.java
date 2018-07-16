package ru.job4j.Set;

import ru.job4j.List.DynamicArray;

import java.util.Iterator;

/**
 * Class SimpleSet Решение задачи 1. Реализовать коллекцию Set на массиве
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 13.07.2018
 */
public class SimpleSet<E> implements Iterable<E> {
    private DynamicArray<E> da = new DynamicArray<>(5);

    public boolean check(E e) {
        boolean contain = false;
        for (E e1 : da) {
            if (e == e1) {
                contain = true;
            }
        }
        return contain;
    }

    public void add(E e) {
        if (!check(e)) {
            da.add(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return da.iterator();
    }
}