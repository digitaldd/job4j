package ru.job4j.Tree;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class StoreTest Решение задачи: Статистику по коллекции
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 13.08.2018
 */
public class StoreTest {
    private List<Store.User> prev = new ArrayList<>();
    private List<Store.User> curr;

    @Before
    public void testInit() {
        prev.add(new Store.User(1, "num1"));
        prev.add(new Store.User(2, "num2"));
        prev.add(new Store.User(3, "num3"));
        prev.add(new Store.User(4, "num4"));
        prev.add(new Store.User(5, "num5"));
        prev.add(new Store.User(6, "num6"));
        prev.add(new Store.User(1, "num1"));
        prev.add(new Store.User(1, "num1"));
        prev.add(new Store.User(1, "num1"));
        curr = new ArrayList<>(prev);
    }

    /**
     * test add
     */
    @Test
    public void ifAddThenAddIsUp() {
        Store store = new Store();
        assertThat(store.infoDiff(prev, curr), is("Diff = 0 Remove = 0 Add = 0"));
        curr.add(new Store.User(10, "num10"));
        assertThat(store.infoDiff(prev, curr), is("Diff = 0 Remove = 0 Add = 1"));
        curr.add(new Store.User(11, "num10"));
        assertThat(store.infoDiff(prev, curr), is("Diff = 0 Remove = 0 Add = 2"));
    }

    /**
     * test set
     */
    @Test
    public void ifSetThenDiffIsUp() {
        Store store = new Store();
        assertThat(store.infoDiff(prev, curr), is("Diff = 0 Remove = 0 Add = 0"));
        curr.set(2, new Store.User(3, "num1"));
        assertThat(store.infoDiff(prev, curr), is("Diff = 1 Remove = 0 Add = 0"));
        curr.set(4, new Store.User(5, "num1"));
        assertThat(store.infoDiff(prev, curr), is("Diff = 2 Remove = 0 Add = 0"));
    }

    /**
     * test remove
     */
    @Test
    public void ifRemoveThenRemoveIsUp() {
        Store store = new Store();
        assertThat(store.infoDiff(prev, curr), is("Diff = 0 Remove = 0 Add = 0"));
        curr.remove(2);
        assertThat(store.infoDiff(prev, curr), is("Diff = 0 Remove = 1 Add = 0"));
        curr.remove(4);
        assertThat(store.infoDiff(prev, curr), is("Diff = 0 Remove = 2 Add = 0"));
    }

    /**
     * test statistic
     */
    @Test
    public void testAllStatistic() {
        Store store = new Store();
        assertThat(store.infoDiff(prev, curr), is("Diff = 0 Remove = 0 Add = 0"));
        curr.set(1, new Store.User(2, "43"));
        assertThat(store.infoDiff(prev, curr), is("Diff = 1 Remove = 0 Add = 0"));
        curr.remove(2);
        assertThat(store.infoDiff(prev, curr), is("Diff = 1 Remove = 1 Add = 0"));
        curr.add(new Store.User(10, "num10"));
        assertThat(store.infoDiff(prev, curr), is("Diff = 1 Remove = 1 Add = 1"));
    }
}