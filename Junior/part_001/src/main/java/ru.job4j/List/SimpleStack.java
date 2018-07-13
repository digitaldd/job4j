package ru.job4j.List;

/**
 * Class SimpleStack Решение задачи 5.3.3. Используя контейнер на базе связанного
 * списка создать контейнер Stack и Queue
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 13.07.2018
 */
public class SimpleStack<T> {
    private SimpleArrayList<T> stack = new SimpleArrayList<>();

    public T poll() {
        return (T) stack.delete();
    }

    public void push(T value) {
        stack.add(value);
    }
}