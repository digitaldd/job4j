package ru.job4j.loop;

/**
 * Class Factorial Решение задачи 4.2. Создать программу вычисляющую факториал
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 10.04.2018
 */
public class Factorial {

    /**
     * calculate factorial number (finish)
     *
     * @param finish last number in cycle
     * @return factorial of number (finish)
     */
    public int calculateFactorial(int finish) {
        int result = 1;
        for (int i = finish; i >= 1; i--) {
            result *= i;
        }
        return result;
    }
}