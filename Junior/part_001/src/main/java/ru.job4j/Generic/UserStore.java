package ru.job4j.Generic;

/**
 * Class UserStore Решение задачи 5.2.2. Реализовать Store<T extends Base>
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 03.07.2018
 */
public class UserStore extends AbstractStore<User> {
    public UserStore(SimpleArray<User> simpleArray) {
        super(simpleArray);
    }
}