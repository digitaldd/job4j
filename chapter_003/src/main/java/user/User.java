package user;

/**
 * Class User Решение задачи 2. Написать программу преобразования List в Map
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 15.05.2018
 */
public class User {
    int id;
    String name;
    String city;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return name + " " + city;
    }
}