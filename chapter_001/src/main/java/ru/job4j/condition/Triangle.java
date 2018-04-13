package ru.job4j.condition;

/**
 * Class Triangle Решение задачи 3.3. Вычисление площади треугольника
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 09.04.2018
 */
public class Triangle {

    private Point a;
    private Point b;
    private Point c;

    /**
     * triangle a,b,c
     *
     * @param a any number
     * @param b any number
     * @param c any number
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод вычисления полупериметра по длинам сторон.
     *
     * Формула.
     *
     * (ab + ac + bc) / 2
     *
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return Перимент.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * Метод должен вычислить площадь треугольника.
     *
     * @return Вернуть прощадь, если треугольник существует или -1, если треугольника нет.
     */
    public double area() {
        double rsl = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        if (this.exist(ab, ac, bc)) {
            double half = period(ab, ac, bc);
            rsl = Math.sqrt(half * (half - ab) * (half - ac) * (half - bc));
        }
        return rsl;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     * Подумайте какое надо написать условие, чтобы определить можно ли построить треугольник.
     *
     * @param ab Длина от точки a b.
     * @param ac Длина от точки a c.
     * @param bc Длина от точки b c.
     */
    private boolean exist(double ab, double ac, double bc) {
        return ab + bc > ac && ac + ab > bc && bc + ac > ab;
    }
}