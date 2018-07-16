package ru.job4j.List;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class LockingIdentifyTest Решение задачи 5.3.4. Задан связанный список. Определить цикличность
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 16.07.2018
 */
public class LockingIdentifyTest {

    /**
     * cycle when the end
     */
    @Test
    public void whenCycleInTheEnd() {
        LockingIdentify li = new LockingIdentify();
        Node<Integer> first = new Node(1);
        Node<Integer> two = new Node(2);
        Node<Integer> third = new Node(3);
        Node<Integer> four = new Node(4);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(li.hasCycle(first), is(true));
    }

    /**
     * cycle when middle
     */
    @Test
    public void whenCycleInTheMiddle() {
        LockingIdentify li = new LockingIdentify();
        Node<String> first = new Node(1);
        Node<String> two = new Node(2);
        Node<String> third = new Node(3);
        Node<String> four = new Node(4);
        first.next = two;
        two.next = third;
        third.next = two;
        four.next = null;
        assertThat(li.hasCycle(first), is(true));
    }

    /**
     * cycle when begin
     */
    @Test
    public void whenCycleInTheBegin() {
        LockingIdentify li = new LockingIdentify();
        Node<Character> first = new Node(1);
        Node<Character> two = new Node(2);
        Node<Character> third = new Node(3);
        Node<Character> four = new Node(4);
        first.next = first;
        two.next = third;
        third.next = four;
        four.next = null;
        assertThat(li.hasCycle(first), is(true));
    }

    /**
     * without cycle
     */
    @Test
    public void IfWithoutCycleThenFalse() {
        LockingIdentify li = new LockingIdentify();
        Node<Boolean> first = new Node(1);
        Node<Boolean> two = new Node(2);
        Node<Boolean> third = new Node(3);
        Node<Boolean> four = new Node(4);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        assertThat(li.hasCycle(first), is(false));
    }
}