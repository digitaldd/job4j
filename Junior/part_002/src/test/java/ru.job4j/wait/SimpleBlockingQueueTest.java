package ru.job4j.wait;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleBlockingQueueTest Решение задачи 1. Реализовать шаблон Producer Consumer
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 13.09.2018
 */
public class SimpleBlockingQueueTest {
    private List list = new ArrayList();
    private SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(5);
    private Thread producer;
    private Thread consumer;

    @Before
    public void before() {
        producer = new Thread(() -> {
            try {
                for (int i = 1; i < 6; i++) {
                    queue.offer(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    list.add(queue.poll());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
    }

    @Test
    public void whenStartProducerThenConsumerGetElements() throws InterruptedException {
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        assertThat(list.get(0), is(1));
        assertThat(list.get(1), is(2));
        assertThat(list.get(2), is(3));
        assertThat(list.get(3), is(4));
        assertThat(list.get(4), is(5));
    }
}