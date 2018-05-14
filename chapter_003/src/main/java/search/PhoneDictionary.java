package search;

import java.util.ArrayList;
import java.util.List;

/**
 * Class PhoneDictionary Решение задачи 1. Телефонный справочник на базе ArrayList
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 14.05.2018
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (!persons.isEmpty() && person.toString().toLowerCase().contains(key.toLowerCase())) {
                result.add(person);
            }
        }
        return result;
    }
}