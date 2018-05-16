package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tracker.Item;
import tracker.Tracker;
import tracker.start.Input;
import tracker.start.StartUI;
import tracker.start.StubInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    /**
     * test add item
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll().get(0).getName(), is("test name"));
    }

    /**
     * test show item
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()).contains(item.getId()), is(true));
    }

    /**
     * test edit name
     */
    @Test
    public void whenEditNameThenTrackerContainsNewName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test1", "desc", "y"});
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
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc2", "y"});
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
        Input input = new StubInput(new String[]{"3", item.getId(), "y"});
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
        Input input = new StubInput(new String[]{"4", item.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()).contains("desc"), is(true));
    }

    /**
     * test find by name
     */
    @Test
    public void whenFindByNameThenTrackerReturnItemWithName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getName(), "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()).contains("test name"), is(true));
    }
}