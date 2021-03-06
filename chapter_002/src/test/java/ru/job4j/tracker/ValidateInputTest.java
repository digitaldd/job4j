package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tracker.start.StubInput;
import tracker.start.ValidateInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * this class contains test - get answer, when value is invalid
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    /**
     * when value is invalid
     */
    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"invalid", "1"}));
        input.ask("Enter", new int[]{1});
        assertThat(this.mem.toString(), is(String.format("Please enter validate data again.%n")));
    }

    @Test
    public void whenNineInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"9", "1"}));
        input.ask("select:", new int[]{1});
        assertThat(this.mem.toString(), is(String.format("Please select key from menu.%n")));
    }
}