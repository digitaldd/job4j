package ru.job4j.array;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Class BubbleSortTest Решение задачи 5.3. Создать программу для сортировки массива методом перестановки
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 10.04.2018
 */
public class BubbleSortTest {

    /**
     * array size 10
     */
    @Test
    public void bubbleSort10() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = new int[]{1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] result = bubbleSort.sort(input);
        int[] expect = new int[]{0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(result, is(expect));
    }

    /**
     * array size 5
     */
    @Test
    public void bubbleSort5() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = new int[]{5, 1, 2, 7, 3};
        int[] result = bubbleSort.sort(input);
        int[] expect = new int[]{1, 2, 3, 5, 7};
        assertThat(result, is(expect));
    }
}