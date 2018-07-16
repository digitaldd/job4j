package ru.job4j.List;

/**
 * Class Node Решение задачи 5.3.4. Задан связанный список. Определить цикличность
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 16.07.2018
 */
public class Node<T> {
    T value;
    Node<T> next;

    Node(T value) {
        this.value = value;
    }
}