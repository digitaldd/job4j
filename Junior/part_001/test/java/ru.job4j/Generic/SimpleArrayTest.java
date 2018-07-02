package ru.job4j.Generic;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class SimpleArrayTest Решение задачи 5.2.1. Реализовать SimpleArray<T>
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 02.07.2018
 */
public class SimpleArrayTest {
    private SimpleArray<Integer> sa = new SimpleArray<>(5);

    @Before
    public void setUp() {
        sa = new SimpleArray<>(5);
        sa.add(1000);
        sa.add(100);
        sa.add(10);
        sa.add(1);
    }

    /**
     * test add and get
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddElementThenArrayContainElement() {
        assertThat(sa.get(0), is(1000));
        sa.add(11);
        assertThat(sa.get(4), is(11));
        sa.add(19);
    }

    /**
     * test set
     */
    @Test
    public void whenSetElementThenArrayContainNewElement() {
        sa.set(0, 290);
        sa.set(1, 200);
        assertThat(sa.get(0), is(290));
        assertThat(sa.get(1), is(200));
    }

    /**
     * test delete
     */
    @Test
    public void whenDeleteElementThenArrayNotContainElement() {
        sa.delete(1);
        assertThat(sa.get(0), is(1000));
        assertThat(sa.get(1) == null, is(true));
        assertThat(sa.get(2), is(10));
    }

    /**
     * test iterator
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextThenNextElement() {
        Iterator it = sa.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1000));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(100));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(10));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}