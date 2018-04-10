package ru.job4j.array;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Class FindLoopTest Решение задачи 5.1. Классический поиск перебором
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 10.04.2018
 */
public class FindLoopTest {

    /**
     * test found 5 in array
     */
    @Test
    public void whenArrayHasLengh5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    /**
     * test found 0 in array
     */
    @Test
    public void find0InArray() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3, 0};
        int value = 0;
        int result = find.indexOf(input, value);
        int expect = 3;
        assertThat(result, is(expect));
    }

    /**
     * test don't found 6 in array
     */
    @Test
    public void notFound6() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3, 0};
        int value = 6;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}