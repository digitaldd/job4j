package bank;

import java.util.List;
import java.util.TreeMap;

/**
 * Class ListCompare Решение задачи Банковские переводы
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 23.05.2018
 */
public class Account {

    private TreeMap<User, List<Account>> map = new TreeMap<>();
    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public Account() {
    }

    public TreeMap<User, List<Account>> getMap() {
        return map;
    }

    public String getRequisites() {
        return requisites;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}