package ru.job4j.List;

/**
 * Class LockingIdentify Решение задачи 5.3.4. Задан связанный список. Определить цикличность
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 16.07.2018
 */
public class LockingIdentify<T> {

    public boolean hasCycle(Node<T> first) {
        Node turtle = first;
        Node hare = first;
        boolean check = false;
        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
            if (turtle == hare) {
                check = true;
                break;
            }
        }
        return check;
    }
}