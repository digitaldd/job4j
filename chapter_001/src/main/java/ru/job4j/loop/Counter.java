package ru.job4j.loop;

/**
 * Class Counter Решение задачи 4.1. Подсчет суммы чётных чисел в диапазоне
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 10.04.2018
 */
public class Counter {

    /**
     * @param start any number (first number in cycle)
     * @param finish any number (last number in cycle)
     * @return sum of even numbers
     */
    public int add(int start, int finish) {
        int result = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }
}