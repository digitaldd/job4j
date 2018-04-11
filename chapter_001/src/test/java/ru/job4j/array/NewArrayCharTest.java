package ru.job4j.array;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Class NewArrayCharTest Решение задачи Проверка, что одно слово находится в другом слове
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 11.04.2018
 */
public class NewArrayCharTest {

    /**
     * at the beginning of the word
     */
    @Test
    public void whenInTheBeginningWord() {
        NewArrayChar word = new NewArrayChar();
        boolean result = word.contains("Hello", "He");
        assertThat(result, is(true));
    }

    /**
     * in the end of the word
     */
    @Test
    public void whenInTheEndWord() {
        NewArrayChar word = new NewArrayChar();
        boolean result = word.contains("HeloMyFriendHello", "llo");
        assertThat(result, is(true));
    }

    /**
     * in the middle of a word
     */
    @Test
    public void whenInTheMiddleWord() {
        NewArrayChar word = new NewArrayChar();
        boolean result = word.contains("distancedistance", "tan");
        assertThat(result, is(true));
    }

    /**
     * not found
     */
    @Test
    public void whenNotFound() {
        NewArrayChar word = new NewArrayChar();
        boolean result = word.contains("distancedistance", "llo");
        assertThat(result, is(false));
    }
}