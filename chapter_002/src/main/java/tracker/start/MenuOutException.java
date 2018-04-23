package tracker.start;

/**
 * Class MenuOutException Решение задачи 1. Обеспечить бесперебойную работу приложения Tracker
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 23.04.2018
 */
public class MenuOutException extends RuntimeException {
    public MenuOutException(String msg) {
        super(msg);
    }
}