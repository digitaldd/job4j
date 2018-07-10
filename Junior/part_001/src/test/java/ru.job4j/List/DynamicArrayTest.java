package ru.job4j.List;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class DynamicArrayTest Решение задачи 5.3.1. Создать динамический список на базе массива
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 10.07.2018
 */
public class DynamicArrayTest {
    private DynamicArray<Integer> da = new DynamicArray<>(5);
    private Iterator it = da.iterator();

    @Before
    public void beforeTest() {
        da.add(1);
        da.add(2);
        da.add(3);
        da.add(4);
    }

    /**
     * check new array size
     */
    @Test
    public void whenNewArrThenSizeIsFive() {
        assertThat(da.container.length, is(5));
    }

    /**
     * check array fill
     */
    @Test
    public void whenAddElementsThenUseGetForCheck() {
        assertThat(da.get(0), is(1));
        assertThat(da.get(1), is(2));
        assertThat(da.get(2), is(3));
        assertThat(da.get(3), is(4));
    }

    /**
     * test auto size and test get ConcurrentModificationException
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenAddElementsAfterAutoSizeUseGetForCheck() {
        da.add(5);
        da.add(6);
        da.add(7);
        assertThat(da.get(4), is(5));
        assertThat(da.get(5), is(6));
        assertThat(da.get(6), is(7));
        assertThat(da.container.length, is(10));
        it.next();
    }

    /**
     * test iterator and test get NoSuchElementException
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextThenNextElement() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        da.add(5);
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(false));
        assertThat(da.container.length, is(5));
        it.next();
    }
}