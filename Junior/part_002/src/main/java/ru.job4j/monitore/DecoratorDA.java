package ru.job4j.monitore;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.List.DynamicArray;

import java.util.Iterator;

/**
 * Class DecoratorDA Решение задачи 3. ThreadSafe динамический список
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 04.09.2018
 */
@ThreadSafe
public class DecoratorDA<E> implements Iterable {
    @GuardedBy("this")
    private final DynamicArray<E> da;

    public DecoratorDA(DynamicArray<E> da) {
        this.da = da;
    }

    synchronized void add(E value) {
        da.add(value);
    }

    synchronized E get(E value) {
        return da.get((Integer) value);
    }

    @Override
    public synchronized Iterator iterator() {
        return da.iterator();
    }
}