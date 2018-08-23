package ru.job4j.Tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class Store Решение задачи: Статистику по коллекции
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 13.08.2018
 */
public class Store<S> {
    S infoDiff(List<User> previous, List<User> current) {
        Map<Integer, String> map = new HashMap<>();
        AtomicInteger diff = new AtomicInteger();
        AtomicInteger add = new AtomicInteger();
        AtomicInteger rem = new AtomicInteger();
        previous.forEach(user -> {
            if (!current.contains(user)) {
                rem.incrementAndGet();
            }
            map.put(user.id, user.name);
        });
        current.forEach(user -> {
            if (map.containsKey(user.id) && !map.get(user.id).equals(user.name)) {
                diff.incrementAndGet();
            } else if (!map.containsKey(user.id)) {
                add.incrementAndGet();
            }
        });
        return (S) ("Diff = " + diff + " Remove = " + (rem.get() - diff.get()) + " Add = " + add);
    }

    static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return id + " " + name;
        }

        @Override
        public int hashCode() {
            int res = 17;
            res = 31 * res + this.id;
            return res;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id &&
                    Objects.equals(name, user.name);
        }
    }
}