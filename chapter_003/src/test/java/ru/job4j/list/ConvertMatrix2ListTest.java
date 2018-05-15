package ru.job4j.list;

import list.ConvertMatrix2List;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ConvertMatrix2ListTest Решение задачи 3. Конвертация двумерного массива в ArrayList
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 15.05.2018
 */
public class ConvertMatrix2ListTest {
    /**
     * test array to list 4 elements (matrix 2x2)
     */
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    /**
     * test array to list 8 elements (matrix 4x2)
     */
    @Test
    public void when4on2ArrayThenList8() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    /**
     * test array to list 8 elements (matrix 2x4)
     */
    @Test
    public void when2on4ArrayThenList8() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
}