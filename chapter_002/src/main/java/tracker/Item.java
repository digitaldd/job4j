package tracker;

/**
 * Class Item Решение задачи 2. Реализовать класс Tracker
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 17.04.2018
 */
public class Item {
    private String id;
    private String name;
    private String desc;
    private long created;

    public Item() {
    }

    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }
    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }
}