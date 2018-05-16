package sort;

/**
 * Class User Решение задачи 1. Организовать сортировку User
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 16.05.2018
 */
public class User implements Comparable<User> {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}