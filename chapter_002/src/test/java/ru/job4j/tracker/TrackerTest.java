package ru.job4j.tracker;

import org.junit.Test;
import tracker.Item;
import tracker.Tracker;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class TrackerTest Решение задачи 2. Реализовать класс Tracker
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 17.04.2018
 */
public class TrackerTest {
    /**
     * test add method
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll().get(0), is(item));
    }

    /**
     * test replace method
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.getAll().get(0).getName(), is("test2"));
    }

    /**
     * test delete method
     */
    @Test
    public void whenDeleteItemThenReturnNewArray() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 1234L);
        tracker.add(second);
        Item third = new Item("test3", "testDescription3", 12345L);
        tracker.add(third);
        tracker.delete(second.getId());
        assertThat(tracker.findAll().size(), is(2));
        assertThat(tracker.findAll().get(0), is(first));
        assertThat(tracker.findAll().get(1), is(third));
    }

    /**
     * test findByName method
     */
    @Test
    public void whenFindByNameThenReturnItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 1234L);
        tracker.add(second);
        assertThat(tracker.findByName(first.getName()), is(first));
        assertThat(tracker.findByName(second.getName()), is(second));
    }

    /**
     * test findById method
     */
    @Test
    public void whenFindByIdThenReturnItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 1234L);
        tracker.add(second);
        assertThat(tracker.findById(first.getId()), is(first));
        assertThat(tracker.findById(second.getId()), is(second));
    }

    /**
     * test FindAll method
     */
    @Test
    public void whenFindAllThenReturnAllItemsWithoutNull() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription", 1234L);
        tracker.add(first);
        tracker.add(second);
        Item[] check = {first, second};
        Item[] check2 = {first};
        assertThat(tracker.findAll().toString().equals(Arrays.toString(check)), is(true));
        tracker.delete(second.getId());
        assertThat(tracker.findAll().toString().equals(Arrays.toString(check2)), is(true));
    }
}