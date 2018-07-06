package ru.job4j.Generic;

/**
 * Class Base Решение задачи 5.2.2. Реализовать Store<T extends Base>
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 03.07.2018
 */
public abstract class Base {
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}