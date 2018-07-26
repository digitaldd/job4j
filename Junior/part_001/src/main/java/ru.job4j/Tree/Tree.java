package ru.job4j.Tree;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * Class Tree Решение задачи 1. Создать элементарную структуру дерева
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 25.07.2018
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int modCount;

    @Override
    public boolean add(E parent, E child) {
        boolean add = false;
        Optional<Node<E>> rt = Optional.ofNullable(root);
        Optional<Node<E>> prnt = Optional.empty();
        if (!rt.isPresent()) {
            root = new Node<>(parent);
            root.add(new Node<>(child));
            add = true;
            modCount++;
        } else {
            prnt = findBy(parent);
        }
        if (rt.isPresent() && prnt.isPresent() && !prnt.get().eqValue(child)) {
            prnt.get().add(new Node<>(child));
            add = true;
            modCount++;
        }
        return add;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    public boolean isBinary() {
        Iterator it = this.iterator();
        Optional<Node<E>> prnt = findBy((E) it.next());
        boolean binar = true;
        while (it.hasNext()) {
            if (prnt.isPresent() && prnt.get().leaves().size() > 2) {
                binar = false;
                break;
            }
            it.next();
        }
        return binar;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            Queue<Node<E>> data = new LinkedList<>();

            {
                data.offer(Tree.this.root);
            }

            @Override
            public boolean hasNext() {
                return !data.isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                Node<E> result = data.poll();
                for (Node<E> leaf : result.leaves()) {
                    data.offer(leaf);
                }
                return result.getValue();
            }
        };
    }
}