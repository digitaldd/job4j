package ru.job4j.calculator;

/**
 * Class Calculate Решение задачи 3.1 Элементарный калькулятор
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 09.04.2018
 */
public class Calculator {

    private double result;

    /**
     * number+number
     *
     * @param first any number
     * @param second any number
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * number-number
     *
     * @param first any number
     * @param second any number
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * number/number
     *
     * @param first any number
     * @param second any number
     */
    public void division(double first, double second) {
        this.result = first / second;
    }

    /**
     * number*number
     *
     * @param first any number
     * @param second any number
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * result of action
     *
     * @return result
     */
    public double getResult() {
        return this.result;
    }
}