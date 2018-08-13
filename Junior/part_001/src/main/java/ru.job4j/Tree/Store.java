package ru.job4j.Tree;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Class Store Решение задачи: Статистику по коллекции
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 13.08.2018
 */
public class Store<S> {
    S infoDiff(List<User> previous, List<User> current) {
        Set<User> cur = new HashSet<>(current);
        Set<User> prev = new HashSet<>(previous);
        cur.removeAll(prev);
        prev.removeAll(current);
        int curSize = cur.size();
        int prevSize = prev.size();
        int diff = 0;
        for (User aCurrent : cur) {
            for (User aPrevious : prev) {
                if (aCurrent.id == aPrevious.id && !aCurrent.name.equals(aPrevious.name)) {
                    diff++;
                    curSize--;
                    prevSize--;
                }
            }
        }
        return (S) ("Diff = " + diff + " Remove = " + prevSize + " Add = " + curSize);
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