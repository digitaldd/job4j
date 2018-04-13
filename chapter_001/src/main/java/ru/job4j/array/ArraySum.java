package ru.job4j.array;

/**
 * Class ArraySum Решение задачи Объединение 2 отсортированных массивов в один.
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 13.04.2018
 */
public class ArraySum {

    /**
     * build sorted array of two sorted arrays
     *
     * @param arr1 any int array (sorted)
     * @param arr2 any int array (sorted)
     * @return sorted array (arr1+arr2)
     */
    public int[] sort(int[] arr1, int[] arr2) {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int[] arr3 = new int[arr1.length + arr2.length];
        while (count1 < arr1.length && count2 < arr2.length) {
            arr3[count3++] = arr1[count1] < arr2[count2] ? arr1[count1++] : arr2[count2++];
        }
        while (count1 < arr1.length) {
            arr3[count3++] = arr1[count1++];
        }
        while (count2 < arr2.length) {
            arr3[count3++] = arr2[count2++];
        }
        return arr3;
    }
}