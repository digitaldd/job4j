package ru.job4j.Tree;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class TreeTest Решение задачи 1. Создать элементарную структуру дерева
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 25.07.2018
 */
public class TreeTest {
    /**
     * test add and findby
     */
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>();
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.findBy(6).isPresent(), is(true));
    }

    /**
     * test findby
     */
    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>();
        tree.add(1, 2);
        assertThat(tree.findBy(7).isPresent(), is(false));
    }

    /**
     * test iterator and get NoSuchElementException
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextThenNextElement() {
        Tree<Integer> tree = new Tree<>();
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        Iterator<Integer> it = tree.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    /**
     * test get ConcurrentModificationException
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenChangeSizeBeforeCallIteratorThenException() {
        Tree<Integer> tree = new Tree<>();
        Iterator<Integer> it = tree.iterator();
        tree.add(1, 2);
        tree.add(1, 3);
        it.next();
    }
}