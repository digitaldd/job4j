package ru.job4j.Map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Class UserTest Решение задачи 2. Не перекрывать equals hashCode
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 18.07.2018
 */
public class UserTest {

    /**
     * two element in map ru.job4j.Map.User@6ae40994=1, ru.job4j.Map.User@1a93a7ca=2
     * that possible, because equals - is not overriding
     * difference links and hash codes
     */
    @Test
    public void whenPrintlnMapThenTwoObject() {
        Map<User, Object> map = new HashMap<>();
        User user = new User("Ivan", 2, new GregorianCalendar(1988, 12, 2));
        User user2 = new User("Ivan", 2, new GregorianCalendar(1988, 12, 2));
        map.put(user, "1");
        map.put(user2, "2");
        System.out.println(map);
    }
}