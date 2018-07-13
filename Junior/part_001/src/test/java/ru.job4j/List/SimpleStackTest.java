package ru.job4j.List;

import org.junit.Test;
import org.junit.Before;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleStackTest Решение задачи 5.3.3. Используя контейнер на базе связанного
 * списка создать контейнер Stack и Queue
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 13.07.2018
 */
public class SimpleStackTest {
    private SimpleStack<Integer> ss = new SimpleStack<>();

    @Before
    public void setUp() {
        ss.push(1);
        ss.push(2);
        ss.push(3);
    }

    @Test
    public void WhenPollThenGetElement() {
        assertThat(ss.poll(), is(3));
        assertThat(ss.poll(), is(2));
        assertThat(ss.poll(), is(1));
    }
}