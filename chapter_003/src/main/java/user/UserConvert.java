package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class UserConvert Решение задачи 2. Написать программу преобразования List в Map
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 15.05.2018
 */
public class UserConvert {
    public static void main(String[] args) {
        User user1 = new User(1, "Fred", "Fili");
        User user2 = new User(2, "Sam", "Orlando");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        UserConvert uc = new UserConvert();
    }

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> resultMap = new HashMap<>();
        for (User user : list) {
            resultMap.put(user.id, user);
        }
        return resultMap;
    }
}