package ru.job4j.Threads;

import javafx.scene.shape.Rectangle;

/**
 * Class RectangleMove Решение задачи 1. Пин-понг
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 23.08.2018
 */
public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private int moveHor = 5;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        while (true) {
            if (rect.getX() == 290 || rect.getX() == 0) {
                moveHor = 0 - moveHor;
            }
            this.rect.setX(this.rect.getX() + moveHor);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}