package ru.job4j.array;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Class ArraySumTest Решение задачи Объединение 2 отсортированных массивов в один.
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 13.04.2018
 */
public class ArraySumTest {

    /**
     * 5+5
     */
    @Test
    public void sortTwoArraysInOne5x5() {
        ArraySum as = new ArraySum();
        int[] arr1 = new int[]{1, 1, 3, 4, 4};
        int[] arr2 = new int[]{0, 1, 2, 4, 6};
        int[] arr3 = as.sort(arr1, arr2);
        int[] expect = {0, 1, 1, 1, 2, 3, 4, 4, 4, 6};
        assertThat(arr3, is(expect));
    }

    /**
     * 4+7
     */
    @Test
    public void sortTwoArraysInOne4x7() {
        ArraySum as = new ArraySum();
        int[] arr1 = new int[]{1, 4, 4, 8};
        int[] arr2 = new int[]{0, 1, 2, 4, 6, 9, 9};
        int[] arr3 = as.sort(arr1, arr2);
        int[] expect = {0, 1, 1, 2, 4, 4, 4, 6, 8, 9, 9};
        assertThat(arr3, is(expect));
    }

    /**
     * 6+3
     */
    @Test
    public void sortTwoArraysInOne6x3() {
        ArraySum as = new ArraySum();
        int[] arr1 = new int[]{1, 4, 4, 8, 10, 11};
        int[] arr2 = new int[]{0, 12, 15};
        int[] arr3 = as.sort(arr1, arr2);
        int[] expect = {0, 1, 4, 4, 8, 10, 11, 12, 15};
        assertThat(arr3, is(expect));
    }
}