package ru.job4j.List;

/**
 * Class SimpleQueue Решение задачи 5.3.3. Используя контейнер на базе связанного
 * списка создать контейнер Stack и Queue
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 13.07.2018
 */
public class SimpleQueue<T> extends SimpleArrayList {
    private int size;
    private Node<T> first;
    private Node<T> last;

    public T poll() {
        Node<T> delete = this.first;
        first = delete.next;
        size--;
        return delete.date;
    }

    public void push(T value) {
        Node<T> newLink = new Node<>(value);
        if (size == 0) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
        size++;
    }

    private class Node<T> {
        T date;
        Node<T> next;

        Node(T date) {
            this.date = date;
        }
    }
}