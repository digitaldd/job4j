package ru.job4j.Set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleSetTest Решение задачи 1. Реализовать коллекцию Set на массиве
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 13.07.2018
 */
public class SimpleSetTest {
    private SimpleSet ss = new SimpleSet();

    @Before
    public void beforeTest() {
        ss.add(1);
        ss.add(2);
        ss.add(3);
        ss.add(3);
    }

    /**
     * check iterator
     */
    @Test
    public void whenArrayContainElementThenNextReturnElement() {
        Iterator it = ss.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }
}