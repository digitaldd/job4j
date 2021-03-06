package ru.job4j.list;

import list.ConvertList2Array;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ConvertList2ArrayTest Решение задачи 3. Конвертация ArrayList в двухмерный массив
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 15.05.2018
 */
public class ConvertList2ArrayTest {
    /**
     * test 3 rows and 7 elements
     */
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    /**
     * test 2 rows and 6 elements
     */
    @Test
    public void when6ElementsThen6() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                2
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6}
        };
        assertThat(result, is(expect));
    }

    /**
     * test 4 rows and 7 elements
     */
    @Test
    public void when4RowsThen4() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                4
        );
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 0}
        };
        assertThat(result, is(expect));
    }
}