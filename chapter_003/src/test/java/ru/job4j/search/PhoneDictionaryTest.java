package ru.job4j.search;

import org.junit.Test;
import search.Person;
import search.PhoneDictionary;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class PhoneDictionaryTest Решение задачи 1. Телефонный справочник на базе ArrayList
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 14.05.2018
 */
public class PhoneDictionaryTest {
    /**
     * test find by name
     */
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    /**
     * test find by surname
     */
    @Test
    public void whenFindBySurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Alex", "Derben", "311331", "Moscow"));
        List<Person> persons = phones.find("deR");
        assertThat(persons.iterator().next().getName(), is("Alex"));
        List<Person> persons2 = phones.find("TEV");
        assertThat(persons2.iterator().next().getName(), is("Petr"));
    }

    /**
     * test find by address
     */
    @Test
    public void whenFindByAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Alex", "Derben", "311331", "Moscow"));
        List<Person> persons = phones.find("MOS");
        assertThat(persons.iterator().next().getName(), is("Alex"));
        List<Person> persons2 = phones.find("nsk");
        assertThat(persons2.iterator().next().getName(), is("Petr"));
    }

    /**
     * test find by phone
     */
    @Test
    public void whenFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Alex", "Derben", "311331", "Moscow"));
        List<Person> persons = phones.find("13");
        assertThat(persons.iterator().next().getName(), is("Alex"));
        List<Person> persons2 = phones.find("5");
        assertThat(persons2.iterator().next().getName(), is("Petr"));
    }
}