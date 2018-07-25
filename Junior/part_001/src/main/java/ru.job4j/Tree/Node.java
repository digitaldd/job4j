package ru.job4j.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Node Решение задачи 1. Создать элементарную структуру дерева
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 25.07.2018
 */
public class Node<E extends Comparable<E>> {
    final List<Node<E>> children = new ArrayList<>();
    private final E value;

    public Node(final E value) {
        this.value = value;
    }

    public void add(Node<E> child) {
        this.children.add(child);
    }

    public List<Node<E>> leaves() {
        return this.children;
    }

    public E getValue() {
        return value;
    }

    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;

    }
}