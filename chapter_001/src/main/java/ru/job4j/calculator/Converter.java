package ru.job4j.calculator;

/**
 * Class Converter Решение задачи 3.2. Конвертер валюты
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 09.04.2018
 */
public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value/70;
    }
    /**
     * Конвертируем евро в рубли.
     * @param value Евро.
     * @return рубли.
     */
    public int euroToRuble(int value) {
        return value*70;
    }
    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллоры
     */
    public int rubleToDollar(int value) {
        return value/60;
    }
    /**
     * Конвертируем доллары в рубли.
     * @param value Доллоры.
     * @return рубли
     */
    public int dollarToRuble(int value) {
        return value*60;
    }
}