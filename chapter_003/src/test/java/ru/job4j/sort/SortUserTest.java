package ru.job4j.sort;

import org.junit.Test;
import sort.SortUser;
import sort.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SortUserTest Решение задачи 1. Организовать сортировку User
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 16.05.2018
 */
public class SortUserTest {
    /**
     * test sort list with 2 elements
     */
    @Test
    public void when2ElementsThenSort2() {
        User user = new User("Jack", 30);
        User user1 = new User("Sam", 23);
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        SortUser sortUser = new SortUser();
        Set<User> su = sortUser.sort(list);
        List<User> check = new ArrayList<>();
        check.add(user1);
        check.add(user);
        assertThat(su.containsAll(check), is(true));
    }
}
