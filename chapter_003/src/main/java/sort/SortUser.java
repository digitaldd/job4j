package sort;

import java.util.*;

/**
 * Class SortUser Решение задачи 1. Организовать сортировку User
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 16.05.2018
 */
public class SortUser {

    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    public List<User> sortNameLength(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int compareAge = o1.getName().compareTo(o2.getName());
                int compareName = Integer.compare(o1.getAge(), o2.getAge());
                return compareAge == 0 ? compareName : compareAge;
            }
        });
        return list;
    }
}