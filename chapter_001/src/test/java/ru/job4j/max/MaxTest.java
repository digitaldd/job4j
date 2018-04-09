package ru.job4j.max;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Class MaxTest Решение задачи 3.2. Максимум из двух чисел
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 09.04.2018
 */
public class MaxTest {

    /**
     * what number is more <
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * what number is more >
     */
    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(3, 0);
        assertThat(result, is(3));
    }

    /**
     * what number is more ==
     */
    @Test
    public void whenSecondEquallyFirst() {
        Max maxim = new Max();
        int result = maxim.max(3, 3);
        assertThat(result, is(3));
    }
}