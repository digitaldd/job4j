package ru.job4j.array;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Class SquareTest Решение задачи 5.0. Заполнить массив степенями чисел
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 10.04.2018
 */
public class SquareTest {

    /**
     * test array (size 3)
     */
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{1, 4, 9};
        assertThat(rst, is(expect));
    }

    /**
     * test array (size 4)
     */
    @Test
    public void whenBound6Then14916() {
        int bound = 4;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{1, 4, 9, 16};
        assertThat(rst, is(expect));
    }

    /**
     * test array (size 2)
     */
    @Test
    public void whenBound2Then14() {
        int bound = 2;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{1, 4};
        assertThat(rst, is(expect));
    }
}