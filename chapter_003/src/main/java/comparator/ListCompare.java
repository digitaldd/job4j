package comparator;

import java.util.Comparator;

/**
 * Class ListCompare Решение задачи 3. Компаратор для строк
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 16.05.2018
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int check = Integer.compare(left.length(), right.length());
        int result = 0;
        for (int i = 0; i < left.length(); i++) {
            if (result == 0) {
                result = Character.compare(left.charAt(i), right.charAt(i));
            } else {
                break;
            }
        }
        return result == 0 ? check : result;
    }
}