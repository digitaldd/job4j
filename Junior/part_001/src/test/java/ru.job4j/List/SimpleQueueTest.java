package ru.job4j.List;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleQueueTest Решение задачи 5.3.3. Используя контейнер на базе связанного
 * списка создать контейнер Stack и Queue
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 13.07.2018
 */
public class SimpleQueueTest {
    private SimpleQueue<Integer> sq = new SimpleQueue<>();

    @Before
    public void setUp() {
        sq.push(1);
        sq.push(2);
        sq.push(3);
    }

    @Test
    public void WhenPollThenGetElement() {
        assertThat(sq.poll(), is(1));
        assertThat(sq.poll(), is(2));
        assertThat(sq.poll(), is(3));
    }
}
