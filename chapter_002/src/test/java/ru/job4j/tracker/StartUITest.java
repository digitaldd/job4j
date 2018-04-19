package ru.job4j.tracker;

import org.junit.Test;
import tracker.Item;
import tracker.Tracker;
import tracker.start.Input;
import tracker.start.StartUI;
import tracker.start.StubInput;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class StartUITest Решение задачи 3. Используя класс StubInput написать
 * тесты проверяющие поведение пользователя
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 19.04.2018
 */
public class StartUITest {
    /**
     * test add item
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }

    /**
     * test show item
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"1", item.getId(), "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    /**
     * test edit name
     */
    @Test
    public void whenEditNameThenTrackerContainsNewName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "1", "test1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test1"));
    }

    /**
     * test edit description
     */
    @Test
    public void whenEditDescThenTrackerContainsNewDesc() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "2", "desc2", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getDesc(), is("desc2"));
    }

    /**
     * test delete item
     */
    @Test
    public void whenDeleteItemThenTrackerNotContainsItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()) == null, is(true));
    }

    /**
     * test find by ID
     */
    @Test
    public void whenFindByIdThenTrackerReturnItemWithId() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    /**
     * test find by name
     */
    @Test
    public void whenFindByNameThenTrackerReturnItemWithName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName()).getName(), is("test name"));
    }
}