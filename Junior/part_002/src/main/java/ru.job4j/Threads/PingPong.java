package ru.job4j.Threads;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Class PingPong Решение задачи 3. Реализовать механизм программной остановки потока
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 23.08.2018
 */
public class PingPong extends Application {
    private static final String JOB4J = "Пинг-понг www.job4j.ru";

    @Override
    public void start(Stage stage) {
        int limitX = 300;
        int limitY = 300;
        Group group = new Group();
        Rectangle rect = new Rectangle(10, 150, 10, 10);
        group.getChildren().add(rect);
        Thread tr = new Thread(new RectangleMove(rect));
        tr.start();
        stage.setScene(new Scene(group, limitX, limitY));
        stage.setTitle(JOB4J);
        stage.setResizable(false);
        stage.show();
        stage.setOnCloseRequest(
                event -> tr.interrupt()
        );
    }
}