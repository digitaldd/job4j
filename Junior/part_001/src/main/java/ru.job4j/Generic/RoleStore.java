package ru.job4j.Generic;

/**
 * Class RoleStore Решение задачи 5.2.2. Реализовать Store<T extends Base>
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 03.07.2018
 */
public class RoleStore extends AbstractStore {
    public RoleStore(SimpleArray<Role> simpleArray) {
        super(simpleArray);
    }
}