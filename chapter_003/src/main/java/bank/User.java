package bank;

import java.util.Objects;

/**
 * Class ListCompare Решение задачи Банковские переводы
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 23.05.2018
 */
public class User {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public User() {
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }

    @Override
    public String toString() {
        return name + " " + passport;
    }

    @Override
    public boolean equals(Object o) {
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(passport, user.passport);
    }
}