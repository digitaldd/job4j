package ru.job4j.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class IteratorSimpleNumberTest Решение задачи 5.1.3. Создать итератор простые числа
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 01.07.2018
 */
public class IteratorSimpleNumberTest {

    private IteratorSimpleNumber it;

    @Before
    public void setUp() {
        it = new IteratorSimpleNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 3571});
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnPrimeNumbersOnly() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3571));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(3571));
    }

    @Test
    public void shouldReturnFalseCauseThereIsNoAnyPrimeNumber() {
        it = new IteratorSimpleNumber(new int[]{4, 6});
        assertThat("should return false, cause there is no any prime number", it.hasNext(), is(false));
    }

    @Test
    public void shouldFirst() {
        it = new IteratorSimpleNumber(new int[]{33});
        boolean prime = it.hasNext();
        assertThat(prime, is(false));
    }

    @Test
    public void shouldSecond() {
        it = new IteratorSimpleNumber(new int[]{33, 33});
        boolean prime = it.hasNext();
        assertThat(prime, is(false));
    }
}