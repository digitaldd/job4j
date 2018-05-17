package ru.job4j.array;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Class TurnTest Решение задачи 5.2. Перевернуть массив
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 10.04.2018
 */
public class TurnTest {

    /**
     * Even Amount
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[]{1, 2, 3, 4};
        int[] result = turner.back(input);
        int[] expect = new int[]{4, 3, 2, 1};
        assertThat(result, is(expect));
    }

    /**
     * Odd Amount
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[]{1, 2, 3, 4, 5};
        int[] result = turner.back(input);
        int[] expect = new int[]{5, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }

    /**
     * random numbers even amount
     */
    @Test
    public void whenTurnArrayRandomNumbersEven() {
        Turn turn = new Turn();
        int[] date = {4, 1, 6, 2};
        int[] resultArray = turn.back(date);
        int[] expectArray = {2, 6, 1, 4};
        assertThat(resultArray, is(expectArray));
    }

    /**
     * random numbers odd amount
     */
    @Test
    public void whenTurnArrayRandomNumbersOdd() {
        Turn turn = new Turn();
        int[] date = {12, 54, 22, 55, 23, 75, 32};
        int[] resultArray = turn.back(date);
        int[] expectArray = {32, 75, 23, 55, 22, 54, 12};
        assertThat(resultArray, is(expectArray));
    }
}