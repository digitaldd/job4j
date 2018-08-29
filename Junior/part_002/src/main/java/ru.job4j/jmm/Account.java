package ru.job4j.jmm;

/**
 * Class Account Решение задачи 1. Проиллюстрировать проблемы с многопоточностью
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 29.08.2018
 */
public class Account {
    private final int id;
    private int amount;

    public Account(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        final Account acc1 = new Account(1);
        final Account acc2 = new Account(2);
        new Thread(() -> acc1.getPay(acc2, 20)).start();
        new Thread(() -> acc2.getPay(acc1, 20)).start();
        System.out.println("1 = " + acc1.getAmount() + "; 2 = " + acc2.getAmount());
    }

    public int getId() {
        return this.id;
    }

    public int getAmount() {
        return this.amount;
    }

    public synchronized void getPay(Account acc, int sum) {
        System.out.format("%s: %s" + " has pay me%n", this.id, acc.getId());
        acc.amount -= sum;
        this.amount += sum;
        acc.checkSum(this);

    }

    public synchronized void checkSum(Account acc) {
        System.out.println("id" + acc.getId() + " = " + acc.getAmount());
    }
}
// В данном примере рассматривается проблема многопоточности, именуемая  Deadlock  или Взаимная блокировка.
// Создано 2 аккуанта с уникальными id  и счетами. Запущено 2 потока:
// оба потока  обращаются к методу getPay с целью получения платежа от другого аккаунта
// метод getPay в свою очередь запускает метод checkSum, в котором может быть рализована логика проверки счета или подтверждения.
// Вместо единовременного получения платежа, получаем блокировку обоих потоков.

// Оба потока имеют циклическую зависимость от пары синхронизированных методов. synchronized - гарантирует, что никакие два
// потока не могут выполнить такой метод одновременно или паралельно.