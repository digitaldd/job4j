package ru.job4j.jmm;

/**
 * Class Jmm Решение задачи 1. Проиллюстрировать проблемы с многопоточностью
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 29.08.2018
 */
public class Jmm {
    public static void main(String[] args) {
        Thread tr = new Thread(new Task());
        tr.start();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main");
        }
    }
}

class Task implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i++);
        }
    }
}

// В данном примере, при использовании многопоточности получаем следующие результаты:

// 1 запуск:
// 0
//main
//1
//main
//2
//main
//3
//main
//4
//main

// 2 запуск:
//main
//0
//1
//main
//2
//main
//3
//main
//4
//main

// Последовательность выполнения меняется и ее невозможно предсказать, как следствие, процедура отладки такого кода
// сложноосуществима. Нет однозначной определенности, уверенности в получении одинакогового результата работы т.е. нет детерменированности.
// Потоки работают паралельно и для них приедусмотрен общий вывод в консоль.