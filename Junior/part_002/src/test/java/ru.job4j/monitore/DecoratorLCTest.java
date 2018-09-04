package ru.job4j.monitore;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.List.LinkedContainer;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Class DecoratorLCTest Решение задачи 3. ThreadSafe динамический список
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 04.09.2018
 */
public class DecoratorLCTest {
    private DecoratorLC<Integer> lc = new DecoratorLC<>(new LinkedContainer<>());

    @Before
    public void beforeTest() {
        lc.add(1);
        lc.add(2);
        lc.add(3);
    }

    /**
     * test get
     */
    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(lc.get(0), is(3));
        assertThat(lc.get(1), is(2));
        assertThat(lc.get(2), is(1));
    }

    /**
     * test get ConcurrentModificationException
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenAddElementsAfterAutoSizeUseGetForCheck() {
        Iterator it = lc.iterator();
        lc.add(5);
        lc.add(6);
        lc.add(7);
        assertThat(lc.get(0), is(7));
        assertThat(lc.get(1), is(6));
        assertThat(lc.get(2), is(5));
        assertThat(lc.get(3), is(3));
        assertThat(lc.get(4), is(2));
        assertThat(lc.get(5), is(1));
        it.next();
    }

    /**
     * test iterator
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextThenNextElement() {
        Iterator it = lc.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    /**
     * test call two iterators
     */
    @Test
    public void whenTwoIterators() {
        Iterator it = lc.iterator();
        Iterator itSec = lc.iterator();
        assertThat(it.next(), is(3));
        assertThat(itSec.next(), is(3));
    }

    /**
     * test HasNext return false if collection is empty
     */
    @Test
    public void whenNodeIsEmptyThenHasNextReturnFalse() {
        DecoratorLC<Integer> lc1 = new DecoratorLC<>(new LinkedContainer<>());
        Iterator<Integer> it = lc1.iterator();
        boolean b = it.hasNext();
        assertFalse(b);
    }
}