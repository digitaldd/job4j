package search;

/**
 * Class Person Решение задачи 1. Телефонный справочник на базе ArrayList
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 14.05.2018
 */
public class Person {
    private String name;
    private String surname;
    private String phone;
    private String address;

    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + phone + " " + address;
    }
}