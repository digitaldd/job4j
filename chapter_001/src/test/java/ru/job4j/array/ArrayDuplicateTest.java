package ru.job4j.array;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Class ArrayDuplicateTest Решение задачи 5.6. Удаление дубликатов в массиве
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 10.04.2018
 */
public class ArrayDuplicateTest {

    /**
     * test with words
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate ad = new ArrayDuplicate();
        String[] check = ad.remove(new String[]{"Привет", "Мир", "Привет", "Супер", "Мир"});
        String[] expect = {"Привет", "Мир", "Супер"};
        assertThat(check, is(expect));
    }

    /**
     * test with numbers
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicateNumbers() {
        ArrayDuplicate ad = new ArrayDuplicate();
        String[] check = ad.remove(new String[]{"17", "14", "17", "11", "5", "5"});
        String[] expect = {"17", "14", "5", "11"};
        assertThat(check, is(expect));
    }
}