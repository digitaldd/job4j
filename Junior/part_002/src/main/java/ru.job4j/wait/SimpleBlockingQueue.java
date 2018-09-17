package ru.job4j.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class SimpleBlockingQueue Решение задачи 1. Реализовать шаблон Producer Consumer
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 13.09.2018
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private final Queue<T> queue = new LinkedList<>();
    private final int size;

    public SimpleBlockingQueue(final int size) {
        this.size = size;
    }

    public void offer(final T value) throws InterruptedException {
        synchronized (queue) {
            if (queue.size() < size) {
                queue.offer(value);
                queue.notify();
            } else {
                while (size >= queue.size()) {
                    queue.wait();
                }
            }
        }
    }

    public T poll() throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty()) {
                queue.wait();
            }
            queue.notify();
        }
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}