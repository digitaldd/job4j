package ru.job4j.max;

/**
 * * Class Max Решение задачи 3.2. Максимум из двух чисел
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 09.04.2018
 */
public class Max {

    /**
     * @param first any number
     * @param second any number
     * @return what number is more
     */
    public int max(int first, int second) {
        return (first > second) ? first : second;
    }

    public int max(int first, int second, int third) {
        int temp = this.max(first, second);
        return this.max(temp, third);
    }
}