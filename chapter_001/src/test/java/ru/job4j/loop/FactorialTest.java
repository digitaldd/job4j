package ru.job4j.loop;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Class FactorialTest Решение задачи 4.2. Создать программу вычисляющую факториал
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 10.04.2018
 */
public class FactorialTest {

    /**
     * test factorial number 5
     */
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        Factorial fact = new Factorial();
        assertThat(fact.calculateFactorial(5), is(120));
    }

    /**
     * test factorial number 0
     */
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial fact = new Factorial();
        assertThat(fact.calculateFactorial(0), is(1));
    }
}