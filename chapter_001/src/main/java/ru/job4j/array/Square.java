package ru.job4j.array;

/**
 * Class Square Решение задачи 5.0. Заполнить массив степенями чисел
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 10.04.2018
 */
public class Square {

    /**
     * method fill array numbers in degree 2
     *
     * @param bound any number
     * @return array
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= rst.length; i++) {
            rst[i - 1] = i * i;
        }
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        return rst;
    }
}