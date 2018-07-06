package ru.job4j.Generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class AbstractStoreTest Решение задачи 5.2.2. Реализовать Store<T extends Base>
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 03.07.2018
 */
public class AbstractStoreTest {
    private UserStore us = new UserStore(new SimpleArray<>(3));
    private RoleStore rs = new RoleStore(new SimpleArray<>(3));

    @Test
    public void whenAddUserAndRoleThenFindByIdReturnIt() {
        User first = new User("1");
        User second = new User("2");
        us.add(first);
        us.add(second);
        assertThat(us.findById("1"), is(first));
        assertThat(us.findById("2"), is(second));
        Role artist = new Role("art");
        Role actor = new Role("act");
        rs.add(artist);
        rs.add(actor);
        assertThat(rs.findById("art"), is(artist));
        assertThat(rs.findById("act"), is(actor));
    }

    @Test
    public void whenDeleteUserOrRoleThenTrue() {
        User first = new User("1");
        User second = new User("2");
        us.add(first);
        us.add(second);
        assertThat(us.delete("1"), is(true));
        assertThat(us.delete("3"), is(false));
        Role artist = new Role("art");
        Role actor = new Role("act");
        rs.add(artist);
        rs.add(actor);
        assertThat(rs.delete("art"), is(true));
        assertThat(rs.delete("at"), is(false));
    }

    @Test
    public void whenReplaceUserOrRoleThenTrue() {
        User first = new User("1");
        User second = new User("2");
        us.add(first);
        us.add(second);
        assertThat(us.replace("1", new User("10")), is(true));
        assertThat(us.replace("3", new User("20")), is(false));
        Role artist = new Role("art");
        Role actor = new Role("act");
        rs.add(artist);
        rs.add(actor);
        assertThat(rs.replace("art", new Role("artist")), is(true));
        assertThat(rs.replace("at", new Role("actor")), is(false));
    }
}