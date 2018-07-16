package ru.job4j.Set;

import ru.job4j.List.LinkedContainer;

import java.util.Iterator;

/**
 * Class SimpleLinkedSet Решение задачи 2. Set реализованный на связном списке
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 13.07.2018
 */
public class SimpleLinkedSet<E> implements Iterable<E> {
    LinkedContainer lc = new LinkedContainer();

    public void add(E e) {
        if (!check(e)) {
            lc.add(e);
        }
    }

    public boolean check(E e) {
        boolean contain = false;
        for (int i = 0; i < lc.getSize(); i++) {
            if (e == lc.get(i)) {
                contain = true;
            }
        }
        return contain;
    }

    @Override
    public Iterator<E> iterator() {
        return lc.iterator();
    }
}