package ru.job4j.monitore;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class UserStorageTest Решение задачи 2. Класс хранилища пользователей UserStorage
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 04.09.2018
 */
public class UserStorageTest {
    private UserStorage us = new UserStorage();
    private User u1 = new User(1, 10);
    private User u2 = new User(2, 20);

    /**
     * test add and size
     */
    @Test
    public void whenAddUserThenSizeUp() {
        assertThat(us.add(u1), is(true));
        assertThat(us.add(u2), is(true));
        assertThat(us.size(), is(2));
    }

    /**
     * test update
     */
    @Test
    public void whenUpdateUserThenUsersAmountIsChange() {
        assertThat(us.update(u1), is(false));
        assertThat(us.add(u1), is(true));
        User user = new User(u1.getId(), 30);
        assertThat(us.update(user), is(true));
        assertThat(us.getAmount(u1), is(30));
    }

    /**
     * test delete
     */
    @Test
    public void whenDeleteUserThenSizeIsDown() {
        assertThat(us.size(), is(0));
        assertThat(us.delete(u1), is(false));
        assertThat(us.add(u1), is(true));
        assertThat(us.size(), is(1));
        assertThat(us.delete(u1), is(true));
        assertThat(us.size(), is(0));
    }

    /**
     * test transfer
     */
    @Test
    public void whenTransferThenTransferAmount() {
        assertThat(us.size(), is(0));
        assertThat(us.add(u1), is(true));
        assertThat(us.add(u2), is(true));
        assertThat(us.size(), is(2));
        assertThat(us.getAmount(u1), is(10));
        assertThat(us.getAmount(u2), is(20));
        assertThat(us.transfer(u1.getId(), u2.getId(), 5), is(true));
        assertThat(us.getAmount(u1), is(5));
        assertThat(us.getAmount(u2), is(25));
        assertThat(us.transfer(u2.getId(), u1.getId(), 10), is(true));
        assertThat(us.getAmount(u1), is(15));
        assertThat(us.getAmount(u2), is(15));
    }
}