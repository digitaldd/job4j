package ru.job4j.loop;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Class Counter Решение задачи 4.1. Подсчет суммы чётных чисел в диапазоне
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 10.04.2018
 */
public class CounterTest {

    /**
     * test sum of even numbers
     */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter count = new Counter();
        assertThat(count.add(1, 10), is(30));
    }
}