package ru.job4j.Generic;

/**
 * interface Store Решение задачи 5.2.2. Реализовать Store<T extends Base>
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 03.07.2018
 */
public interface Store<T extends Base> {
    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}