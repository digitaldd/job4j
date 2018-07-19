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
     * Решение задачи 2. Не перекрывать equals hashCode
     * two element in map ru.job4j.Map.User@6ae40994=1, ru.job4j.Map.User@1a93a7ca=2
     * that possible, because equals and hashcode - is not overriding
     * difference links and hash codes.
     * When we put element user2 in map:
     * 1.for begin calculate hashcode of element (not overriding, so it can be different on user's hashcode)
     * 2.calculate cell (bucket) in map. Calculation based on hashcode (if hashcode are different, then for user
     * and user2 can be create tab[i] = newNode(hash, key, value, null); )
     * collision = false
     * <p>
     * <p>
     * Решение задачи 3. Переопределить только hashCode
     * two element in map ru.job4j.Map.User@6ae40994=1, ru.job4j.Map.User@1a93a7ca=2
     * hash code was overriding, but map contain two elements
     * equals also need overriding
     * user hash = 864154285
     * user2 hash = 864154285
     * When we put element user2 in map:
     * 1.for begin calculate hashcode of element (hashcode is overriding and they are equal)
     * 2.calculate cell (bucket) in map. Calculation based on hashcode (if hashcode are equal, then will be
     * selected existing user's node) ((p = tab[i = (n - 1) & hash]) == null) = false
     * collision = true
     * 3.(p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))) - return false
     * because equals - is not overriding. user.equals(user2) = false
     * 4.In user's node (calculate with hashcode) will be execute search element (in cycle), where next == null
     * 5.user.next=user2
     * <p>
     * <p>
     * Решение задачи 4. Переопределить только equals
     * two elements in map {ru.job4j.Map.User@4e515669=2, ru.job4j.Map.User@4dcbadb4=1}
     * hashcode - is not overriding
     * equals - was overriding
     * 1.for begin calculate hashcode of element (not overriding, so it can be different on user's hashcode)
     * 2.calculate cell (bucket) in map. Calculation based on hashcode (if hashcode are different, then for user
     * and user2 can be create tab[i] = newNode(hash, key, value, null);)
     * collision = false
     * 3.but if hashcode are equal, then check:
     * (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))) - return true
     * because equals - is overriding. user.equals(user2) = true
     * 4.user will be overwriting user2
     * In this case - hashcode are different
     * <p>
     * <p>
     * Решение задачи 5. Перекрывать и equals и hashCode
     * one element in map {ru.job4j.Map.User@3381f2ad=2}
     * hashcode and equals - was overriding
     * user was overwritten user2
     * map correct
     * 1.for begin calculate hashcode of element (hashcode is overriding and they are equal)
     * 2.calculate cell (bucket) in map. Calculation based on hashcode (if hashcode are equal, then will be
     * selected existing user's node)
     * 3.(p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))) - return true
     * because equals and hashcode - is overriding. user.equals(user2) = true
     * 4.user will be overwriting user2
     * collision = true
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