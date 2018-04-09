package ru.job4j.condition;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Class TriangleTest Решение задачи 3.3. Вычисление площади треугольника
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 09.04.2018
 */
public class TriangleTest {

    /**
     * test construction triangle by 3 points
     */
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        // создаем три объекта класса Point.
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        // Создаем объект треугольник и передаем в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);
        // Вычисляем площадь.
        double result = triangle.area();
        // Задаем ожидаемый результат.
        double expected = 2D;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 0.1));
    }

    /**
     * false construction
     */
    @Test
    public void triangleFalse() {
        // создаем три объекта класса Point.
        Point a = new Point(3, 0);
        Point b = new Point(5, 0);
        Point c = new Point(2, 0);
        // Создаем объект треугольник и передаем в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);
        // Вычисляем площадь.
        double result = triangle.area();
        // Задаем ожидаемый результат.
        double expected = -1D;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 0.1));
    }
}