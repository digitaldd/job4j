package ru.job4j.Map;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleHashMapTest Решение задачи 8. Реализовать собственную структуру данных - HashMap
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 23.07.2018
 */
public class SimpleHashMapTest {
    private SimpleHashMap<Integer, String> hashMap;

    /**
     * test insert
     */
    @Before
    public void testInit() {
        hashMap = new SimpleHashMap<>();
        hashMap.insert(null, "null");
        hashMap.insert(1, "one");
        hashMap.insert(2, "two");
        hashMap.insert(3, "three");
        hashMap.insert(4, "four");
        hashMap.insert(5, "five");
        hashMap.insert(6, "six");
        hashMap.insert(7, "seven");
        hashMap.insert(7, "seven");
        hashMap.insert(70, "s");
        hashMap.insert(null, "null1");
    }

    /**
     * test count
     */
    @Test
    public void whenMapGetCountThen8() {
        assertThat(hashMap.getCount(), is(8));
    }

    /**
     * test resize
     */
    @Test
    public void whenMapResize14() {
        assertThat(hashMap.getSize(), is(10));
    }

    /**
     * test get
     */
    @Test
    public void whenGetByKeyThenReturnValue() {
        assertThat(hashMap.get(null), is("null"));
        assertThat(hashMap.get(2), is("two"));
        assertThat(hashMap.get(7), is("seven"));
        assertThat(hashMap.get(5), is("five"));
        boolean checkNull = hashMap.get(70) == null;
        assertThat(checkNull, is(true));
    }

    /**
     * test delete
     */
    @Test
    public void whenDeleteElementThenReturnTrueOrFalse() {
        assertThat(hashMap.delete(null), is(true));
        assertThat(hashMap.delete(2), is(true));
        assertThat(hashMap.delete(7), is(true));
        assertThat(hashMap.delete(15), is(false));
        assertThat(hashMap.getCount(), is(5));
        assertThat(hashMap.getSize(), is(10));
    }

    /**
     * test iterator and get NoSuchElementException
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextThenNextElement() {
        Iterator<SimpleHashMap.Bucket> it = hashMap.iterator();
        Iterator<SimpleHashMap.Bucket> itSec = hashMap.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().value, is("null"));
        assertThat(itSec.hasNext(), is(true));
        assertThat(itSec.next().value, is("null"));
        assertThat(itSec.hasNext(), is(true));
        assertThat(itSec.next().value, is("one"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().value, is("one"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().value, is("two"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().value, is("three"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().value, is("four"));
        assertThat(it.hasNext(), is(true));
        it.next();
        it.next();
        it.next();
        it.next();
    }

    /**
     * get ConcurrentModificationException
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenAddElementsAfterAutoSizeUseGetForCheck() {
        Iterator<SimpleHashMap.Bucket> it = hashMap.iterator();
        hashMap.insert(8, "55");
        hashMap.insert(9, "55");
        hashMap.insert(10, "55");
        hashMap.insert(11, "55");
        hashMap.insert(12, "55");
        hashMap.insert(13, "55");
        hashMap.insert(14, "55");
        assertThat(hashMap.getSize(), is(20));
        it.next();
    }
}