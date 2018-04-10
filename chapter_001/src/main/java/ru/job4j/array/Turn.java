package ru.job4j.array;

/**
 * Class Turn Решение задачи 5.2. Перевернуть массив
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 10.04.2018
 */
public class Turn {

    /**
     * turn array
     *
     * @param array with any numbers
     * @return reverse array
     */
    public int[] back(int[] array) {
        int[] reverse = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reverse[i] = array.length - i;
        }
        return reverse;
    }
}