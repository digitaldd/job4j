package ru.job4j.array;

/**
 * Class BubbleSort Решение задачи 5.3. Создать программу для сортировки массива методом перестановки
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 10.04.2018
 */
public class BubbleSort {

    /**
     * @param array any size
     * @return sorted array
     */
    public int[] sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}