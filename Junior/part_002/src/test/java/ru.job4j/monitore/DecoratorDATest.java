package ru.job4j.monitore;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.List.DynamicArray;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Class DecoratorDATest Решение задачи 3. ThreadSafe динамический список
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 04.09.2018
 */
public class DecoratorDATest {
    private DecoratorDA<Integer> da = new DecoratorDA<>(new DynamicArray<>(5));

    @Before
    public void beforeTest() {
        da.add(1);
        da.add(2);
        da.add(3);
        da.add(4);
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
     * test get and ConcurrentModificationException
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenAddElementsAfterAutoSizeUseGetForCheck() {
        Iterator it = da.iterator();
        da.add(5);
        da.add(6);
        da.add(7);
        assertThat(da.get(4), is(5));
        assertThat(da.get(5), is(6));
        assertThat(da.get(6), is(7));
        it.next();
    }

    /**
     * test call two iterators
     */
    @Test
    public void whenTwoIterators() {
        Iterator it = da.iterator();
        Iterator itSec = da.iterator();
        assertThat(it.next(), is(1));
        assertThat(itSec.next(), is(1));
    }

    /**
     * test HasNext return false if array is empty
     */
    @Test
    public void whenArrayIsEmptyThenHasNextReturnFalse() {
        DecoratorDA<Integer> da1 = new DecoratorDA<>(new DynamicArray<>(5));
        Iterator<Integer> it = da1.iterator();
        boolean b = it.hasNext();
        assertFalse(b);
    }
}