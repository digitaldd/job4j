package ru.job4j.monitore;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.List.LinkedContainer;

import java.util.Iterator;

/**
 * Class DecoratorLC Решение задачи 3. ThreadSafe динамический список
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 04.09.2018
 */
@ThreadSafe
public class DecoratorLC<E> implements Iterable {
    @GuardedBy("this")
    private final LinkedContainer<E> lc;

    public DecoratorLC(LinkedContainer<E> lc) {
        this.lc = lc;
    }

    synchronized void add(E value) {
        lc.add(value);
    }

    synchronized E get(E value) {
        return lc.get((Integer) value);
    }

    @Override
    public synchronized Iterator iterator() {
        return lc.iterator();
    }
}