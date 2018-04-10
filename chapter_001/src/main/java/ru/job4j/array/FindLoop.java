package ru.job4j.array;

/**
 * Class FindLoop Решение задачи 5.1. Классический поиск перебором
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 10.04.2018
 */
public class FindLoop {

    /**
     *find el in array (size = data)
     * @param data any number (array size)
     * @param el any number (element of array)
     * @return if found, then return index, else return -1
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }
}