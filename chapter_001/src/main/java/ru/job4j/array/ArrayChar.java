package ru.job4j.array;

/**
 * Class ArrayChar Решение задачи 5.5. Слова начинается с ...
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 10.04.2018
 */
public class ArrayChar {

    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     *
     * @param prefix префикс.
     * @return если слово начинаеться с префикса
     */
    public boolean startWith(String prefix) {
        return (String.valueOf(data).startsWith(String.valueOf(prefix)));
    }
}