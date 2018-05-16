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

    /**
     * test sort by name
     */
    @Test
    public void whenSortByNameThenSortAndReturnSortedList() {
        User user = new User("Sergey", 25);
        User user1 = new User("Ivan", 30);
        User user2 = new User("Sergey", 20);
        User user3 = new User("Ivan", 25);
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        SortUser sortUser = new SortUser();
        List<User> su = sortUser.sortNameLength(list);
        List<User> check = new ArrayList<>();
        check.add(user1);
        check.add(user3);
        check.add(user);
        check.add(user2);
        assertThat(su, is(check));
    }

    /**
     * test sort by name and age
     */
    @Test
    public void whenSortByNameAndAgeThenSortAndReturnSortedList() {
        User user = new User("Sergey", 25);
        User user1 = new User("Ivan", 30);
        User user2 = new User("Sergey", 20);
        User user3 = new User("Ivan", 25);
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        SortUser sortUser = new SortUser();
        List<User> su = sortUser.sortByAllFields(list);
        List<User> check = new ArrayList<>();
        check.add(user3);
        check.add(user1);
        check.add(user2);
        check.add(user);
        assertThat(su, is(check));
    }
}