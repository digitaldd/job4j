package ru.job4j.List;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Class LinkedContainerTest Решение задачи 5.3.2. Создать контейнер на базе связанного списка
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 11.07.2018
 */
public class LinkedContainerTest {
    private LinkedContainer<Integer> node;

    @Before
    public void beforeTest() {
        node = new LinkedContainer<>();
        node.add(1);
        node.add(2);
        node.add(3);
    }

    /**
     * test get
     */
    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(node.get(0), is(3));
        assertThat(node.get(1), is(2));
        assertThat(node.get(2), is(1));
    }

    /**
     * test get size
     */
    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(node.getSize(), is(3));
    }

    /**
     * test get ConcurrentModificationException
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenAddElementsAfterAutoSizeUseGetForCheck() {
        Iterator it = node.iterator();
        node.add(5);
        node.add(6);
        node.add(7);
        assertThat(node.get(0), is(7));
        assertThat(node.get(1), is(6));
        assertThat(node.get(2), is(5));
        assertThat(node.get(3), is(3));
        assertThat(node.get(4), is(2));
        assertThat(node.get(5), is(1));
        assertThat(node.getSize(), is(6));
        it.next();
    }

    /**
     * test iterator
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextThenNextElement() {
        Iterator it = node.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(false));
        assertThat(node.getSize(), is(3));
        it.next();
    }

    /**
     * test call two iterators
     */
    @Test
    public void whenTwoIterators() {
        Iterator it = node.iterator();
        Iterator itSec = node.iterator();
        assertThat(it.next(), is(3));
        assertThat(itSec.next(), is(3));
    }

    /**
     * test HasNext return false if array is empty
     */
    @Test
    public void whenNodeIsEmptyThenHasNextReturnFalse() {
        LinkedContainer<Integer> nodeSec;
        nodeSec = new LinkedContainer<>();
        Iterator<Integer> it = nodeSec.iterator();
        boolean b = it.hasNext();
        assertFalse(b);
    }
}