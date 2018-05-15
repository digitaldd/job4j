package ru.job4j.user;

import org.junit.Test;
import user.User;
import user.UserConvert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class UserConvertTest Решение задачи 2. Написать программу преобразования List в Map
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 15.05.2018
 */
public class UserConvertTest {
    /**
     * test convert list to hash map with 2 elements
     */
    @Test
    public void when2ElementsThenHashMap2() {
        User user1 = new User(1, "Fred", "Fili");
        User user2 = new User(2, "Sam", "Orlando");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        UserConvert uc = new UserConvert();
        HashMap<Integer, User> result = uc.process(userList);
        assertThat(result.toString().contains("1=Fred Fili, 2=Sam Orlando"), is(true));
    }
}