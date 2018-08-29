package ru.job4j.monitore;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class Count Решение задачи 1. класс Count и метод int increment
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 29.08.2018
 */
@ThreadSafe
public class Count {
    @GuardedBy("this")
    private int value;

    public synchronized void increment() {
        this.value++;
    }

    public int get() {
        return this.value;
    }
}