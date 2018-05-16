package sort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class SortUser Решение задачи 1. Организовать сортировку User
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 16.05.2018
 */
public class SortUser {

    public Set<User> sort(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.compareTo(o2);
            }
        });
        return new TreeSet<>(list);
    }
}