package ru.job4j.array;

/**
 * Class NewArrayChar Решение задачи Проверка, что одно слово находится в другом слове
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 11.04.2018
 */
public class NewArrayChar {

    /**
     * @param origin any word
     * @param sub search word
     * @return true or false
     */
    boolean contains(String origin, String sub) {
        char[] value = sub.toCharArray();
        char[] word = origin.toCharArray();
        int count = 0;
        for (int i = 0; i < origin.length(); i++) {
            if (count == sub.length()) {
                break;
            }
            for (int j = 0; j < sub.length(); j++) {
                if (word[i] == value[j]) {
                    count++;
                }
            }
        }
        return count == sub.length();
    }
}