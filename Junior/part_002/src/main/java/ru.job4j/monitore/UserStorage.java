package ru.job4j.monitore;

import java.util.concurrent.ConcurrentHashMap;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class UserStorage Решение задачи 2. Класс хранилища пользователей UserStorage
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 04.09.2018
 */
@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private ConcurrentHashMap<Integer, User> map = new ConcurrentHashMap<>();

    boolean add(User user) {
        int size = map.size();
        map.putIfAbsent(user.getId(), user);
        return map.size() - size == 1;
    }

    synchronized boolean update(User user) {
        int amount;
        if (map.keySet().contains(user.getId())) {
            amount = map.get(user.getId()).getAmount();
            map.get(user.getId()).setAmount(user.getAmount());
        } else {
            return false;
        }
        return map.get(user.getId()).getAmount() != amount;
    }

    synchronized boolean delete(User user) {
        if (map.contains(user)) {
            map.remove(user.getId());
        } else {
            return false;
        }
        return !map.contains(user);
    }

    synchronized boolean transfer(int fromId, int toId, int amount) {
        int amountFrom = map.get(fromId).getAmount() - amount;
        int amountTo = map.get(toId).getAmount() + amount;
        if (map.contains(map.get(fromId)) && map.contains(map.get(toId))) {
            map.get(fromId).setAmount(map.get(fromId).getAmount() - amount);
            map.get(toId).setAmount(map.get(toId).getAmount() + amount);
        }
        return map.get(fromId).getAmount() == amountFrom && map.get(toId).getAmount() == amountTo;
    }

    synchronized int size() {
        return map.size();
    }

    synchronized int getAmount(User user) {
        return map.get(user.getId()).getAmount();
    }
}

class User {

    private int id;
    private int amount;

    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + amount;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return !(id != user.id || amount != user.amount);
    }
}