package ru.job4j.list;

import list.ConvertMatrix2List;
import org.junit.Test;

import java.util.ArrayList;
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

    /**
     * test convert list with arrays to list Integer (2 arrays and 5 elements)
     */
    @Test
    public void when2With5ElementsThenList5() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[] input = {1, 2};
        int[] input2 = {3, 4, 5};
        List<int[]> la = new ArrayList<>();
        la.add(input);
        la.add(input2);
        List<Integer> result = list.convert(la);
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5
        );
        assertThat(result, is(expect));
    }

    /**
     * test convert list with arrays to list Integer (4 arrays and 10 elements)
     */
    @Test
    public void when4With10ElementsThenList10() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[] input = {1, 2};
        int[] input2 = {3, 4, 5};
        int[] input3 = {6, 7, 8};
        int[] input4 = {9, 10};
        List<int[]> la = new ArrayList<>();
        la.add(input);
        la.add(input2);
        la.add(input3);
        la.add(input4);
        List<Integer> result = list.convert(la);
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        );
        assertThat(result, is(expect));
    }
}