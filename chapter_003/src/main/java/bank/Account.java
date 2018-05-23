package bank;

import java.util.List;
import java.util.TreeMap;

public class Account {

    private TreeMap<User, List<Account>> map = new TreeMap<>();

    public void setValue(double value) {
        this.value = value;
    }

    private double value; //money
    private String requisites; // bank count

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
}