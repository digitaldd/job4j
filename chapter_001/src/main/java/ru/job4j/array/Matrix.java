package ru.job4j.array;

/**
 * Class Matrix Решение задачи 5.4. Двухмерный массив. Таблица умножения
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 10.04.2018
 */
public class Matrix {

    /**
     * method create table of multiple
     *
     * @param size any number
     * @return result of multiple in array (table)
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}