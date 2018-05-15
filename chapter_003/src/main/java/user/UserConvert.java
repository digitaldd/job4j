package user;

import java.util.HashMap;
import java.util.List;

/**
 * Class UserConvert Решение задачи 2. Написать программу преобразования List в Map
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 15.05.2018
 */
public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> resultMap = new HashMap<>();
        for (User user : list) {
            resultMap.put(user.id, user);
        }
        return resultMap;
    }
}