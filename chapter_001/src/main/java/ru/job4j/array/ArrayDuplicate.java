package ru.job4j.array;

import java.util.Arrays;

/**
 * Class ArrayDuplicate Решение задачи 5.6. Удаление дубликатов в массиве
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 10.04.2018
 */
public class ArrayDuplicate {

    /**
     * remove all duplicate in array
     *
     * @param data array with data
     * @return array without duplicates
     */
    public String[] remove(String[] data) {
        int length = data.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (data[i].equals(data[j])) {
                    data[j] = data[length - 1];
                    length--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(data, length);
    }
}