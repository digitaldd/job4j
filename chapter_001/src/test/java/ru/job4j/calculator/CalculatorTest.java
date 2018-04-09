package ru.job4j.calculator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Test calculator.
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @version $Id$
 * @since 09.04.2018
 */
public class CalculatorTest {

    /**
     * Test calculator add.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test calculator subtract.
     */
    @Test
    public void subtractTest() {
        Calculator calc = new Calculator();
        calc.subtract(2D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Test calculator division.
     */
    @Test
    public void divisionTest() {
        Calculator calc = new Calculator();
        calc.division(4D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test calculator multiple.
     */
    @Test
    public void multipleTest() {
        Calculator calc = new Calculator();
        calc.multiple(4D, 2D);
        double result = calc.getResult();
        double expected = 8D;
        assertThat(result, is(expected));
    }
}
