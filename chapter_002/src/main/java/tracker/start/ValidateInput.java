package tracker.start;

/**
 * Class ValidateInput Решение задачи 1. Обеспечить бесперебойную работу приложения Tracker
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 23.04.2018
 */
public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}